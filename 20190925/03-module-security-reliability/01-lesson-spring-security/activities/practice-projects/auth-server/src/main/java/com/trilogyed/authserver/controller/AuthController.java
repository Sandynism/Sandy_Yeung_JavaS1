package com.trilogyed.authserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public Principal getPrincipal(Principal principal) {
        System.out.println("Accessing Principal Access Information");
        return principal;
    }
}
