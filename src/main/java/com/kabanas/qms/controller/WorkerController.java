package com.kabanas.qms.controller;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WorkerController {

    @Autowired
    WorkService workService;

    @PostMapping(value = "/worker")
    public void finishClientService(@RequestBody Customer customer, @CookieValue("auth") String fooCookie){
        workService.verifyClient(customer,Integer.parseInt(fooCookie.split(",")[0]));// достаю из куков самый первый эллемент (id)
    }
    @PostMapping(value = "/worker")
    public void completeService(@CookieValue("auth") String fooCookie){
        workService.completeService(Integer.parseInt(fooCookie.split(",")[0]));// достаю из куков самый первый эллемент (id)
    }
}
