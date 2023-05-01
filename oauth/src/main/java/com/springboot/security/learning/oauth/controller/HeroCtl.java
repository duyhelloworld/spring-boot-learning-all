package com.springboot.security.learning.oauth.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.learning.oauth.model.Hero;

@RestController
@RequestMapping("/hero")
public class HeroCtl {
    private static final List<Hero> HEROS = Arrays.asList(
        new Hero(1, "Superman"),
        new Hero(2, "Batman"),
        new Hero(3, "WonderWoman"),
        new Hero(4, "ShangChi")
    );

    @GetMapping(path = "/anonymous")
    public ResponseEntity<String> anonymous(){
        return ResponseEntity.ok().body("Annoymous accessing ....");
    }

    @GetMapping("/all")
    private List<Hero> getAllStudent(){
        return HEROS.subList(0, HEROS.size());
    }

    @GetMapping(path = "/{id}")
    private Hero getStudent(@PathVariable("id") Integer id){
        return HEROS.stream()
        .filter(student -> id.equals(student.getId()))
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Student " + id + " not found"));
    }

    @GetMapping
    private ResponseEntity<String> userHome(Authentication authentication) {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.out.println("Mapped to /user");
        System.out.println(username + "\n" + password);
        return ResponseEntity.ok("User logined");
    }
}
