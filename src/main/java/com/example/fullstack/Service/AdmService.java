package com.example.fullstack.Service;

import com.example.fullstack.DTO.AdmDTO;
import com.example.fullstack.Entity.AdmEntity;
import com.example.fullstack.Repository.AdmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmService {
    private final AdmRepository admRepository;
    public  void save(AdmDTO admDTO) {
        // dto를 entity로 변환
        AdmEntity admEntity = AdmEntity.toAdmEntity(admDTO);
        admRepository.save(admEntity);
    }

    public AdmDTO login(AdmDTO admDTO){
        // 입력된 아이디를 db에서 조회 --> db 비번과 입력된 비번이 일치하는지 확인
        Optional<AdmEntity> byAdmId = admRepository.findByAdmId(admDTO.getAdmId());
        if(byAdmId.isPresent()){
            // 조회된 결과가 있다면
            AdmEntity admEntity = byAdmId.get();

            if(admEntity.getAdmPass().equals(admDTO.getAdmPass())){
                // 비밀번호가 일치
                // entity
                AdmDTO dto = AdmDTO.toAdmDTO(admEntity);
                return dto;
            } else{
                // 비밀번호 불일치

            }
        } else {
            // 조회된 결과가 없다면
            return null;
        }
        return null;
    }
}