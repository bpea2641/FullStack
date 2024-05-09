package com.example.fullstack.Controller;

import com.example.fullstack.DTO.NoticeDTO;
import com.example.fullstack.Service.NoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String notice(Pageable pageable, Model model) {
        // NoticeService를 통해 페이징된 공지사항 정보를 가져옴
        Page<NoticeDTO> noticePage = noticeService.findPagedNotices(pageable);

        // 가져온 페이징된 공지사항 정보를 Model에 담아서 View로 전달
        model.addAttribute("noticePage", noticePage);

        return "notice/index"; // View 이름 수정
    }

    @GetMapping("/notice_detail/{id}")
    public String findById(@PathVariable Long id, Model model){
        noticeService.updateHits(id);
        NoticeDTO noticeDTO = noticeService.findById(id);
        model.addAttribute("notice", noticeDTO);
        return "/notice/notice_detail";
    }
}
