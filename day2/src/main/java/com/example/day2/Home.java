package com.example.day2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("/")
    public String hello() {
        return "index";
    }
    @GetMapping("/about.html")
    public String about() {
        return "about";
    }

    @GetMapping("/contact.html")
    public String contact() {
        return "contact";
    }
}
