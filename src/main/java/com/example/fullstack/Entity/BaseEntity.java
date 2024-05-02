package com.example.fullstack.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false) // 업데이트에서는 관련 No
    private LocalDateTime createdTime; // 등록시간

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updatedTime; // 수정시간
}
