package com.dymometr.Dymometr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    //Ping controller
    @GetMapping(path = "/")
    public String ping() {
        return "You are connected to API";
    }
}
