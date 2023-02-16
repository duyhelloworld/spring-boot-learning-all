package com.duyhelloworld.baedungfirstwebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Value(value = "${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("AppName", appName);
        return "home";
    }
}
