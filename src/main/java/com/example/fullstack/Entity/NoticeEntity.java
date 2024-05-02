package com.example.fullstack.Entity;

import com.example.fullstack.DTO.NoticeDTO;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "notice")
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String noticeTitle;

    @Column(length = 20, nullable = false)
    private String noticeName;

    @Column(length = 500)
    private String noticeContent;

    @Column
    private int noticeHit;

    @Column
    private LocalDateTime noticeCreatedTime;

    @Column
    private LocalDateTime noticeUpdatedTime;

    public static NoticeEntity toSaveEntity(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = new NoticeEntity();
        noticeEntity.setNoticeTitle(noticeDTO.getNoticeTitle());
        noticeEntity.setNoticeName(noticeDTO.getNoticeName());
        noticeEntity.setNoticeContent(noticeDTO.getNoticeContent());
        noticeEntity.setNoticeHit(0);
        noticeEntity.setNoticeCreatedTime(LocalDateTime.now());
        noticeEntity.setNoticeUpdatedTime(LocalDateTime.now());
        return noticeEntity;
    }

    public LocalDateTime getCreatedTime() {
        return noticeCreatedTime;
    }

    public LocalDateTime getUpdatedTime() {
        return noticeUpdatedTime;
    }
}
