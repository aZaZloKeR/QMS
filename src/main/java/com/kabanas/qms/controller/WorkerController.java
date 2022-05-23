package com.kabanas.qms.controller;

import com.kabanas.qms.db.model.Customer;
import com.kabanas.qms.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @PostMapping(value = "/worker")
    public void finishClientService(@RequestBody Customer customer, @CookieValue("auth") String fooCookie){
        workerService.verifyClient(customer,Integer.parseInt(fooCookie.split(",")[0]));// достаю из куков самый первый эллемент (id)
    }
    @PostMapping(value = "/worker")
    public void completeService(@CookieValue("auth") String fooCookie){
        workerService.completeService(Integer.parseInt(fooCookie.split(",")[0]));// достаю из куков самый первый эллемент (id)
    }

    @GetMapping(value = "/leaveWorkplace")
    public void leaveWorkplace(@PathVariable int id){
        workerService.leaveWorkplace(id);
    }
}
