package com.company.app.learn_build_ssr.controller.API;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myAPI {
    @PostMapping(value = "/api")
    public String helloApi() {
        return "Hello API";
    }
}
