package com.example.fullstack.Controller;


import com.example.fullstack.DTO.MemberDTO;
import com.example.fullstack.Service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String login(){

        return "/member/login";
    }

    @PostMapping("/member/join")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        System.out.println("memberDTO =" + memberDTO);
        memberService.save(memberDTO);
        return "index";
    }

    @PostMapping("/member/save")
    public String save1(@ModelAttribute MemberDTO memberDTO, HttpSession session, HttpServletResponse response) throws IOException {
        MemberDTO loginResult = memberService.login(memberDTO);
        if (loginResult != null){
            // 로그인 성공
            session.setAttribute("userName", loginResult.getUserName());
            session.setAttribute("userId", loginResult.getUserId());
            return "/arsha/index.html";
        } else {
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('아이디 혹은 비번을 확인하세요.'); history.go(-1);</script>");
            out.flush();
        }
        return "/";
    }

    @GetMapping("/member/join")
    public String join(){
        return "/member/join";
    }

    @PostMapping("/member/id-check")
    public @ResponseBody String idCheck(@RequestParam("userId") String userId) {
        System.out.println("userId =" + userId);
        String checkResult = memberService.idCheck(userId);
        return checkResult;
    }

    @GetMapping("/member/logout")
    public String loginout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}