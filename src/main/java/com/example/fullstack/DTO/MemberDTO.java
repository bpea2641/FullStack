package com.example.fullstack.DTO;

import com.example.fullstack.Entity.MemberEntity;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String userId;
    private String userPass;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userIntro;
    private String userPost;
    private String userAddress1;
    private String userAddress2;
    private String userBirth;
    private String userGender;
    private String userCareer;


    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setUserId(memberEntity.getUserId());
        memberDTO.setUserPass(memberEntity.getUserPass());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setUserPhone(memberEntity.getUserPhone());
        memberDTO.setUserEmail(memberEntity.getUserEmail());
        memberDTO.setUserIntro(memberEntity.getUserIntro());
        memberDTO.setUserPost(memberEntity.getUserPost());
        memberDTO.setUserAddress1(memberEntity.getUserAddress1());
        memberDTO.setUserAddress2(memberEntity.getUserAddress2());
        memberDTO.setUserBirth(memberEntity.getUserBirth());
        memberDTO.setUserGender(memberEntity.getUserGender());
        memberDTO.setUserCareer(memberEntity.getUserCareer());
        return memberDTO;
    }
}