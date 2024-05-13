package com.example.fullstack.Controller;

import com.example.fullstack.DTO.MemberDTO;
import com.example.fullstack.DTO.PortfolioDTO;
import com.example.fullstack.Service.MemberService;
import com.example.fullstack.Service.PortfolioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Transactional
public class PortfolioController {

    private final PortfolioService portfolioService;
    private final MemberService memberService;

    @PostMapping("/portfolio/save/{id}")
    public String save(@ModelAttribute PortfolioDTO portfolioDTO, Model model, @PathVariable Long id) throws IOException {

        // 회원 이름으로 회원을 찾음
        Optional<MemberDTO> optionalMember = memberService.findById(id);
        if (optionalMember.isPresent()) {
            MemberDTO memberDTO = optionalMember.get();
            portfolioDTO.setId(memberDTO.getId());
        } else {
            // 회원을 찾을 수 없는 경우 예외 처리
            // 예: throw new RuntimeException("회원을 찾을 수 없음");
        }

        // 포트폴리오 저장
        portfolioService.save(portfolioDTO);

        // 포트폴리오 목록을 다시 조회하여 모델에 추가
        List<PortfolioDTO> portfolioDTOList = portfolioService.findAll();
        model.addAttribute("portfolioList", portfolioDTOList);

        // 포트폴리오를 저장한 후 마이페이지로 리다이렉트
        return "redirect:/mypage/" + id;

    }

}
