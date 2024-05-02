package com.example.fullstack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "/index.html";
    }

    @GetMapping("/arsha")
    public String arsha() {
        return "/arsha/index.html";
    }
}