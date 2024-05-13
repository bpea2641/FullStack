package com.example.fullstack.Service;

import com.example.fullstack.DTO.PortfolioDTO;
import com.example.fullstack.Entity.MemberEntity;
import com.example.fullstack.Entity.PortfolioEntity;
import com.example.fullstack.Repository.PortfoiloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PortfolioService {

    private final PortfoiloRepository portfoiloRepository;

    public void save(PortfolioDTO portfolioDTO) throws IOException {
        // 포트폴리오 파일 저장
        MultipartFile portfolioFile = portfolioDTO.getPortfolioFile();
        String originalFilename = portfolioFile.getOriginalFilename();
        String storedFileName = System.currentTimeMillis() + "_" + originalFilename;
        String savePath = "C:/springboot_img/" + storedFileName;
        portfolioFile.transferTo(new File(savePath));

        // 포트폴리오 엔티티 생성 및 저장
        PortfolioEntity portfolioEntity = PortfolioEntity.toPortfolioEntity(portfolioDTO);
        Long savedId = portfoiloRepository.save(portfolioEntity).getId();

        // 저장된 포트폴리오 엔티티 가져오기
        PortfolioEntity savedPortfolio = portfoiloRepository.findById(savedId).orElse(null);
        if (savedPortfolio != null) {
            // 포트폴리오에 속한 회원 정보 설정
            MemberEntity memberEntity = savedPortfolio.getMemberEntity();
            portfolioEntity.setMemberEntity(memberEntity);
            // 포트폴리오 파일 정보 설정
            portfolioEntity.setOriginalFileName(originalFilename);
            portfolioEntity.setStoredFileName(storedFileName);
            // 저장
            portfoiloRepository.save(portfolioEntity);
        }
    }


    public List<PortfolioDTO> findAll() {
        List<PortfolioEntity> portfolioEntityList = portfoiloRepository.findAll();
        List<PortfolioDTO> portfolioDTOList = new ArrayList<>();
        for(PortfolioEntity portfolioEntity: portfolioEntityList) {
            portfolioDTOList.add(PortfolioDTO.toPortfolioDTO(portfolioEntity));
        }
        return portfolioDTOList;
    }
}

