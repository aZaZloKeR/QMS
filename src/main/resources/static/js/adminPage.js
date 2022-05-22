let singularUrl = "/QMS/service";
let pluralUrl = "/QMS/services";

let dataMap;

//overwrite json
function getListAttributes() {
    //json with 'element'(DOM) and 'jsonName'
    return [
        {element: document.getElementById("servicesSelect"), jsonName: "id", type: "int"},
        {element: document.getElementById("name"), jsonName: "name", type: "string"},
        {element: document.getElementById("description"), jsonName: "description", type: "string"},
        {element: document.getElementById("isActive"), jsonName: "active", type: "bool"},
        {element: document.getElementById("isVisibleForClient"), jsonName: "visible", type: "bool"},
    ];
}

function getJsonFromForm() {
    let jsonForm = {};
    for (let attr of getListAttributes()) {
        let value;
        if (attr.type === "int") {
            value = parseInt(attr.element.value);
        }
        if (attr.type === "bool") {
            value = attr.element.checked;
        } else {
            value = attr.element.value;
        }
        jsonForm[attr.jsonName] = value;
    }
    console.log(jsonForm);
    return jsonForm;
}

async function updateDataInMap() {
    let tempData = await getData(pluralUrl); //overwrite
    tempData = tempData._embedded.services;
    let tempMap = new Map();
    for (let item of tempData) {
        let tempArr = item._links.self.href.split('/');
        let id = tempArr[tempArr.length - 1];
        tempMap.set(id, item);
    }
    console.log(tempMap);
    dataMap = tempMap;
}

updateDataInMap().then(FillSelect).then(FillForm);

function createService() {
    postData(pluralUrl, getJsonFromForm()).then(updateDataInMap).then(FillSelect).then(FillForm)
}

function updateService() {
    let json = getJsonFromForm();
    putData(pluralUrl + "/" + json.id, json).then(updateDataInMap).then(FillSelect).then(FillForm)
}

function deleteService() {
    let json = getJsonFromForm();
    deleteData(pluralUrl + "/" + json.id).then(updateDataInMap).then(FillSelect).then(FillForm)
}

function FillSelect() {
    let select = document.getElementById("servicesSelect");
    while (select.firstChild) {
        select.firstChild.remove();
    }

    select.add(new Option("", ""));

    for (const item of dataMap.entries()) {
        let value = item[0];
        let text = item[1].name;
        select.add(new Option(text, value));
    }
    console.log("FillSelect");
    console.log(select);
}

function ClearForm() {
    for (let attr of getListAttributes()) {
        if (attr.jsonName === "id") continue;
        if (attr.type === "bool") attr.element.checked = false;
        else attr.element.value = "";
    }
    console.log("ClearForm");
}

function FillForm() {
    let chosenId = document.getElementById("servicesSelect").value
    if (chosenId === "") {
        ClearForm();
        document.getElementById("post").disabled = false;
        document.getElementById("put").disabled = true;
        return;
    }
    document.getElementById("post").disabled = true;
    document.getElementById("put").disabled = false;
    for (let attr of getListAttributes()) {
        if (attr.jsonName === "id") {
            attr.element.value = chosenId;
        } else if (attr.type === "bool") {
            attr.element.checked = dataMap.get(chosenId)[attr.jsonName];
        } else {
            attr.element.value = dataMap.get(chosenId)[attr.jsonName];
        }
    }

}

//can be export
async function getData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
    });
    return await response.json(); // parses JSON response into native JavaScript objects
}

async function postData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'POST', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        }, redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return await response.json(); // parses JSON response into native JavaScript objects
}

async function putData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'PUT', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        }, redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
        body: JSON.stringify(data) // body data type must match "Content-Type" header
    });
    return await response.json(); // parses JSON response into native JavaScript objects
}

async function deleteData(url = '', data = {}) {
    // Default options are marked with *
    const response = await fetch(url, {
        method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *client
    });
    return await response.text(); // parses JSON response into native JavaScript objects
}

