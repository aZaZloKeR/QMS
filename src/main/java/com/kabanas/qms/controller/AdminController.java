package com.kabanas.qms.controller;

import com.kabanas.qms.db.representation.AuthRepresentation;
import com.kabanas.qms.service.AuthService;
import com.kabanas.qms.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AdminController {
    @Autowired
    AuthService authService;
    @Autowired
    QueueService queueService;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> checkAuth(@RequestBody AuthRepresentation authRepresentation, HttpServletResponse response){
       return authService.checkAuth(authRepresentation,response);
    }

    @PostMapping(value = "/checkQueue")
    public void checkQueue(@PathVariable int id){// пришёл id сервиса, по нему надо создать Interaction
       // queueService.createInteraction(id);
    }

}
