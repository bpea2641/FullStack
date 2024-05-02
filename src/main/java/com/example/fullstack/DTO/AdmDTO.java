package com.example.fullstack.DTO;

import com.example.fullstack.Entity.AdmEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AdmDTO {
    private Long id;
    private String admId;
    private String admPass;
    private String admName;

    public static AdmDTO toAdmDTO(AdmEntity admEntity){
        AdmDTO admDTO = new AdmDTO();
        admDTO.setId(admDTO.getId());
        admDTO.setAdmId(admDTO.getAdmId());
        admDTO.setAdmPass(admDTO.getAdmPass());
        admDTO.setAdmName(admDTO.getAdmName());
        return admDTO;
    }
}