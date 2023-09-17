package com.teamdrawer.teamdrawerapi.model;

import com.teamdrawer.teamdrawerapi.DTO.PlayerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter
// @Setter
@Data
@Entity
@NoArgsConstructor
public class PlayerModel {

    public PlayerModel(PlayerDTO bodyDto){
        this.nome = bodyDto.nome();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;
    
}
