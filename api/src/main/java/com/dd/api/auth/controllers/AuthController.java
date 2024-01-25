package com.dd.api.auth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diamond-data/api/auth")
public class AuthController {
    
    @GetMapping
    @RequestMapping("xyz")
    public String connected() {
	return "AuthController Online";
    }
    
    
}