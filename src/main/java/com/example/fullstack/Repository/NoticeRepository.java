package com.example.fullstack.Repository;
import com.example.fullstack.Entity.NoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoticeRepository extends JpaRepository<NoticeEntity, Long> {

    @Modifying
    @Query(value = "update NoticeEntity b set b.noticeHit = b.noticeHit + 1 where b.id=:id")
    void updateHit(@Param("id") Long id);

    @Query("SELECT p FROM NoticeEntity p ORDER BY p.id DESC")
    List<NoticeEntity> findAllDesc();
}