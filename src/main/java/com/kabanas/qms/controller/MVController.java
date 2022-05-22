package com.kabanas.qms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("ui")
public class MVController {

    @GetMapping(value = "services")
    public String Services(){
        return "services";
    }
}
