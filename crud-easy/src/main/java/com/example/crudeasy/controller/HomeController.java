package com.example.crudeasy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }
}
