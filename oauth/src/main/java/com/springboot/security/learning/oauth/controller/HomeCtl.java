package com.springboot.security.learning.oauth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeCtl {
    
    @GetMapping(path = { "/", "/home" })
    public ModelAndView home(){
        return new ModelAndView("home").addObject("version", "0.0.1");
    }

    @GetMapping(path = "/shop")
    public ModelAndView shop() {
        return new ModelAndView("shop");
    }

    @GetMapping("/say-hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from API");
    }

    @GetMapping("/say-goodbye")
    public ResponseEntity<String> sayGoodBye() {
        return ResponseEntity.ok("Goodbye from API");
    }
}
