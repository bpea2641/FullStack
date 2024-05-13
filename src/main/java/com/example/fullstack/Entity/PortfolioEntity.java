package com.example.fullstack.Entity;

import com.example.fullstack.DTO.PortfolioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class PortfolioEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String portfolioName;

    @Column
    private String portfolioContent;

    @Column
    private String originalFileName;

    @Column
    private String storedFileName;

    @Column
    private Integer fileAttached;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static PortfolioEntity toPortfolioEntity(MemberEntity memberEntity, String originalFileName, String storedFileName) {
        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setPortfolioName(portfolioEntity.portfolioName);
        portfolioEntity.setPortfolioContent(portfolioEntity.portfolioContent);
        portfolioEntity.setOriginalFileName(originalFileName);
        portfolioEntity.setStoredFileName(storedFileName);
        portfolioEntity.setMemberEntity(memberEntity);
        return portfolioEntity;
    }

    public static PortfolioEntity toPortfolioEntity(PortfolioDTO portfolioDTO) {
        PortfolioEntity portfolioEntity = new PortfolioEntity();
        portfolioEntity.setPortfolioName(portfolioDTO.getPortfolioName());
        portfolioEntity.setPortfolioContent(portfolioDTO.getPortfolioContent());
        portfolioEntity.setFileAttached(1);
        return portfolioEntity;
    }

}
