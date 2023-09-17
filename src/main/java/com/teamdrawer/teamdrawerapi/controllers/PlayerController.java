package com.teamdrawer.teamdrawerapi.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PlayerController {

    @GetMapping("times")
     public String getTeams(){
        return "Testando rota get";
    }

    @PostMapping("jogador")
    public String createPlayer(){
        return "Testando rota post";
    }

    @DeleteMapping("jogador/all")
    public String deleteAllPlayers(){
        return "Testando rota delete";
    }
    
}
