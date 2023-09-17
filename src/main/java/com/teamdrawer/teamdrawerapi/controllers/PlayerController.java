package com.teamdrawer.teamdrawerapi.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
     public ResponseEntity<Map<String, List<String>>> getTeams(){
        Map<String, List<String>> teams = playerService.getTeamsService();
        return ResponseEntity.ok(teams);
    }

    @PostMapping("jogador")
    public ResponseEntity createPlayer(@RequestBody PlayerDTO req){
        playerService.createPlayerService(req);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("jogador/all")
    public ResponseEntity deleteAllPlayers(){
        playerService.deleteAllPlayers();
        return ResponseEntity.ok().build();
    }
    
}
