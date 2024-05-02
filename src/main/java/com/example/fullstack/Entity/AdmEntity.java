package com.example.fullstack.Entity;

import com.example.fullstack.DTO.AdmDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admin")
public class AdmEntity {
    @Id //Pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
    private Long Id;

    @Column()
    private String admId;

    @Column()
    private String admPass;

    @Column()
    private String admName;

    public static AdmEntity toAdmEntity(AdmDTO admDTO){
        AdmEntity admEntity = new AdmEntity();
        admEntity.setAdmId(admDTO.getAdmId());
        admEntity.setAdmPass(admDTO.getAdmPass());
        admEntity.setAdmName(admDTO.getAdmName());
        return admEntity;
    }
}