package com.example.fullstack.Service;

import com.example.fullstack.DTO.NoticeDTO;
import com.example.fullstack.Entity.NoticeEntity;
import com.example.fullstack.Repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Transactional
    public void save(NoticeDTO noticeDTO) {
        NoticeEntity noticeEntity = NoticeEntity.toSaveEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
    }

    public Page<NoticeDTO> findPagedNotices(Pageable pageable) {
        Page<NoticeEntity> noticeEntities = noticeRepository.findAll(pageable);
        return noticeEntities.map(NoticeDTO::toNoticeDTO);
    }

    @Transactional
    public void updateHits(Long id) {
        noticeRepository.updateHit(id);
    }

    public NoticeDTO findById(Long id) {
        return noticeRepository.findById(id)
                .map(NoticeDTO::toNoticeDTO)
                .orElse(null);
    }

    @Transactional
    public void update(Long id, NoticeDTO noticeDTO) {
        noticeRepository.findById(id).ifPresent(entity -> {
            entity.setNoticeTitle(noticeDTO.getNoticeTitle());
            entity.setNoticeName(noticeDTO.getNoticeName());
            entity.setNoticeContent(noticeDTO.getNoticeContent());
            entity.setNoticeUpdatedTime(LocalDateTime.now());
            noticeRepository.save(entity);
        });
    }

    @Transactional
    public void delete(Long id) {
        noticeRepository.deleteById(id);
    }
}