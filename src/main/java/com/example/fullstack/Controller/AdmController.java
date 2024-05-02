package com.example.fullstack.Controller;

import com.example.fullstack.DTO.AdmDTO;
import com.example.fullstack.DTO.NoticeDTO;
import com.example.fullstack.Service.AdmService;
import com.example.fullstack.Service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
@RequiredArgsConstructor
public class AdmController {
    // 생성자 주입
    private final AdmService admService;
    private final NoticeService noticeService;

    @GetMapping("/adm/notice")
    public String notice_list(Pageable pageable, Model model){
        // NoticeService를 통해 페이징된 공지사항 정보를 가져옴
        Page<NoticeDTO> noticePage = noticeService.findPagedNotices(pageable);

        // 가져온 페이징된 공지사항 정보를 Model에 담아서 View로 전달
        model.addAttribute("noticePage", noticePage);

        return "adm/notice_list"; // View 이름 수정
    }

    @GetMapping("/adm/noticeWrite")
    public String notice_write(){
        return "/adm/notice_write";
    }

    @PostMapping("/adm/noticeSave")
    public String noticeSave(@ModelAttribute NoticeDTO noticeDTO){
        System.out.println("noticeDTO =" + noticeDTO);
        noticeService.save(noticeDTO);
        return "redirect:/adm/notice";
    }

    @GetMapping("/adm/notice_detail/{id}")
    public String findById(@PathVariable Long id, Model model){
        noticeService.updateHits(id);
        NoticeDTO noticeDTO = noticeService.findById(id);
        model.addAttribute("notice", noticeDTO);
        return "/adm/notice_detail";
    }


    @GetMapping("/adm")
    public String admForm(){
        return "admin";
    }

    @GetMapping("/admForm")
    public String admForm1() {
        return "admForm";
    }

    @PostMapping("/admSuccess")
    public String admSuccess(@ModelAttribute AdmDTO admDTO){
        log.info("admDTO = " + admDTO);
        admService.save(admDTO);
        return "admForm";
    }

    @PostMapping("/admSave")
    public String admSave(@ModelAttribute AdmDTO admDTO, HttpSession session){
        AdmDTO loginResult = admService.login(admDTO);
        if (loginResult != null) {
            // 로그인 성공
            session.setAttribute("admName", loginResult.getAdmName());
            return "/adm/index";
        } else {
            return "/";
        }
    }

    @GetMapping("/admOk")
    public String admOK(){
        return "/adm/index";
    }




    @GetMapping("/adm/notice_edit/{id}")
    public String noticeEdit(@PathVariable Long id, Model model) {
        NoticeDTO noticeDTO = noticeService.findById(id);
        model.addAttribute("notice", noticeDTO);
        return "/adm/notice_edit";
    }

    @PostMapping("/adm/noticeUpdateSubmit/{id}")
    public String noticeUpdateSubmit(@PathVariable Long id, @ModelAttribute NoticeDTO noticeDTO) {
        noticeService.update(id, noticeDTO); // 서비스를 통해 공지사항 수정
        return "redirect:/adm/notice_detail/" + id; // 수정한 공지사항 상세 페이지로 리다이렉트
    }

    @GetMapping("/adm/notice_delete/{id}")
    public String noticeDelete(@PathVariable Long id) {
        noticeService.delete(id); // 서비스를 통해 공지사항 삭제
        return "redirect:/adm/notice"; // 삭제 후 공지사항 목록 페이지로 리다이렉트
    }


}