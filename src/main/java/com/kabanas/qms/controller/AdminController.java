package com.kabanas.qms.controller;

import com.kabanas.qms.db.representation.AuthRepresentation;
import com.kabanas.qms.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AdminController {
    @Autowired
    AuthService authService;

    @PostMapping(value = "/auth")
    public ResponseEntity<?> checkAuth(@RequestBody AuthRepresentation authRepresentation, HttpServletResponse response){
       return authService.checkAuth(authRepresentation,response);
    }



}
