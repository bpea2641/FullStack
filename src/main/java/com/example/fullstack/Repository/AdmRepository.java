package com.example.fullstack.Repository;

import com.example.fullstack.Entity.AdmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmRepository extends JpaRepository<AdmEntity, Long> {
    // select * from admin where AdmId=?
    Optional<AdmEntity> findByAdmId(String AdmId);
}