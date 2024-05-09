package com.example.fullstack.Controller;

import com.example.fullstack.DTO.MemberDTO;
import com.example.fullstack.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ArshaController {

    private final MemberService memberService;

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

    @GetMapping("/homepage/{id}")
    public String homepage(@PathVariable Long id, Model model) {
        if (id != null) {
            Optional<MemberDTO> optionalMember = memberService.findById(id);
            if (optionalMember.isPresent()) {
                MemberDTO memberDTO = optionalMember.get();
                model.addAttribute("member", memberDTO);
                return "/arsha/homepage.html";
            }
        }
        return "redirect:/login"; // 회원 정보가 없거나 잘못된 요청일 경우 로그인 페이지로 리다이렉션
    }


    @GetMapping("/mypage/{id}")
    public String findByIdUser(@PathVariable Long id, Model model) {
        Optional<MemberDTO> optionalMember = memberService.findById(id);
        if (optionalMember.isPresent()) {
            MemberDTO memberDTO = optionalMember.get();
            model.addAttribute("member", memberDTO);
            return "/arsha/mypage.html";
        }
        return "redirect:/login";
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
