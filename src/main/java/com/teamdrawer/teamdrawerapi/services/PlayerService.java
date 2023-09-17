package com.teamdrawer.teamdrawerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamdrawer.teamdrawerapi.DTO.PlayerDTO;
import com.teamdrawer.teamdrawerapi.model.PlayerModel;
import com.teamdrawer.teamdrawerapi.repositories.PlayerRepository;

@Service
public class PlayerService {
    
    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerModel> getPlayersService(){
        return  playerRepository.findAll();
    }

    public List<PlayerModel> getTeamsService(){
        List<PlayerModel> allPlayers = getPlayersService();
        System.out.println("Todos os jofadores" + allPlayers);
        return allPlayers;
    }

    public String createPlayerService(PlayerDTO player){
        playerRepository.save(new PlayerModel(player));
        return "PLayer created with sucess";
    }

    public String deleteAllPlayers(){
        playerRepository.deleteAll();
        return "Deletion executed with sucess";
    }
    
}
