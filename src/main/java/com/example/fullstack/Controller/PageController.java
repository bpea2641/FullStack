package com.example.fullstack.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/mypage")
    public String mypage() {
        return "/page/mypage.html";
    }

    @GetMapping("/search")
    public String search() {
        return "/page/search.html";
    }
}
