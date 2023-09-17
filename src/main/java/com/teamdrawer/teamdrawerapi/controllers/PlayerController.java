package com.teamdrawer.teamdrawerapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamdrawer.teamdrawerapi.DTO.PlayerDTO;
import com.teamdrawer.teamdrawerapi.model.PlayerModel;
import com.teamdrawer.teamdrawerapi.services.PlayerService;

@RestController
@RequestMapping("/")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("times")
     public List<String> getTeams(){
        List<String> teams = playerService.getTeamsService();
        return teams;
    }

    @PostMapping("jogador")
    public String createPlayer(@RequestBody PlayerDTO req){
        playerService.createPlayerService(req);
        return "Testando rota post";
    }

    @DeleteMapping("jogador/all")
    public String deleteAllPlayers(){
        playerService.deleteAllPlayers();
        return "Testando rota delete";
    }
    
}
