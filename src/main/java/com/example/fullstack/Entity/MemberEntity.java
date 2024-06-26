package com.example.fullstack.Entity;

import com.example.fullstack.DTO.MemberDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String userPass;

    @Column
    private String userName;

    @Column
    private String userPhone;

    @Column
    private String userEmail;

    @Column
    private String userIntro;

    @Column
    private String userPost;

    @Column
    private String userAddress1;

    @Column
    private String userAddress2;

    @Column
    private String userBirth;

    @Column
    private String userGender;

    @Column
    private String userCareer;

    @Column
    private int fileAttached; // 1 or 0

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PortfolioEntity> memberFileEntityList = new ArrayList<>();

    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setUserId(memberDTO.getUserId());
        memberEntity.setUserPass(memberDTO.getUserPass());
        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setUserPhone(memberDTO.getUserPhone());
        memberEntity.setUserEmail(memberDTO.getUserEmail());
        memberEntity.setUserIntro(memberDTO.getUserIntro());
        memberEntity.setUserPost(memberDTO.getUserPost());
        memberEntity.setUserAddress1(memberDTO.getUserAddress1());
        memberEntity.setUserAddress2(memberDTO.getUserAddress2());
        memberEntity.setUserBirth(memberDTO.getUserBirth());
        memberEntity.setUserGender(memberDTO.getUserGender());
        memberEntity.setUserCareer(memberDTO.getUserCareer());
        return memberEntity;
    }
}