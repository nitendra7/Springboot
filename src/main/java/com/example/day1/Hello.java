package com.example.day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class Hello {
    @GetMapping("/")

    public String greeting(){
        return "Welcome to the SpringBoot";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/bhole")
    public String bhole(){
        return "Jai Bholenath";
    }
    @GetMapping("radhe")
    public String radhe(){
        return "Radhey Radhey";
    }

}
