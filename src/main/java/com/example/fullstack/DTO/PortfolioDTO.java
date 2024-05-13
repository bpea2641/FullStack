package com.example.fullstack.DTO;


import com.example.fullstack.Entity.PortfolioEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PortfolioDTO {
    private Long id;
    private String portfolioName;
    private String portfolioContent;

    private MultipartFile portfolioFile;
    String originalFileName; // 원본 파일 이름
    String storedFileName; // 서버 저장용 파일 이름

    private int fileAttached=0;

    public PortfolioDTO(Long id, String portfolioName, String portfolioContent) {
        this.id = id;
        this.portfolioName = portfolioName;
        this.portfolioContent = portfolioContent;
    }

    public PortfolioDTO() {

    }

    public static PortfolioDTO toPortfolioDTO(PortfolioEntity portfolioEntity) {
        PortfolioDTO portfolioDTO = new PortfolioDTO();
        portfolioDTO.setId(portfolioEntity.getId());
        portfolioDTO.setPortfolioName(portfolioEntity.getPortfolioName());
        portfolioDTO.setPortfolioContent(portfolioEntity.getPortfolioContent());

        Integer fileAttached = portfolioEntity.getFileAttached();
        if (fileAttached != null) {
            portfolioDTO.setFileAttached(fileAttached.intValue());
        }

        return portfolioDTO;
    }

}
