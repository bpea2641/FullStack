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

    @GetMapping("/arsha/login")
    public String arsha_login() {
        return "/member/login.html";
    }

    @GetMapping("/arsha/member")
    public String arsha_member() {
        return "/member/join.html";
    }

    @GetMapping("/portfolio-details")
    public String portfolio_details() {
        return "/arsha/portfolio-details.html";
    }

    @GetMapping("/starter-page")
    public String starter_page() {
        return "/arsha/starter-page.html";
    }
}
