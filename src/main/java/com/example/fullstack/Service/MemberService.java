package com.example.fullstack.Service;

import com.example.fullstack.DTO.MemberDTO;
import com.example.fullstack.Entity.MemberEntity;
import com.example.fullstack.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public String idCheck(String userId) {
        Optional<MemberEntity> byUserID = memberRepository.findByUserId(userId);
        if (byUserID.isPresent()) {
            //조회결과가 없다면 --> 등록된 아이디가 있다. (사용할 수 없다)
            return null;
        } else {
            //조회 결과가 있다 --> 사용가능하다
            return "OK";
        }
    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byUserId = memberRepository.findByUserId(memberDTO.getUserId());
        if(byUserId.isPresent()){
            // 조회된 결과가 있다면
            MemberEntity memberEntity = byUserId.get();
            if(memberEntity.getUserPass().equals(memberDTO.getUserPass())){
                // 비밀번호가 일치
                // entity --> dto 변환
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
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

    public Optional<MemberDTO> findById(Long id) {
        return memberRepository.findById(id).map(MemberDTO::toMemberDTO);
    }


}