package com.teamdrawer.teamdrawerapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamdrawer.teamdrawerapi.model.PlayerModel;
import com.teamdrawer.teamdrawerapi.repositories.PlayerRepository;

@Service
public class PlayerService {
    
    @Autowired
    PlayerRepository playerRepository;

    public List<PlayerModel> getPlayersService(){
        return  playerRepository.findAll();
    }

    public void getTeamsService(){
        List<PlayerModel> allPlayers = getPlayersService();
        System.out.println("Todos os jofadores" + allPlayers);
    }

    public String createPlayerService(PlayerModel player){
        playerRepository.save(player);
        return "PLayer created with sucess";
    }

    public String deleteAllPlayers(){
        playerRepository.deleteAll();
        return "Deletion executed with sucess";
    }
    
}
