package com.teamdrawer.teamdrawerapi.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, List<String>> getTeamsService(){
        List<PlayerModel> allPlayers = getPlayersService();
        
        List<String> listNames = allPlayers.stream()
        .map(player -> player.getNome().toString())
        .collect(Collectors.toList());

        Map<String, List<String>> timesFormados = new HashMap<>();
        int i = 1;

        for (String jogador : listNames) {
            String[] arrayNome = jogador.split(" ");
            String sobrenome = arrayNome[1];
            char primeiraLetraSobrenome = sobrenome.charAt(0);

            String chave = "time" + primeiraLetraSobrenome;

            if (!timesFormados.containsKey(chave)) {
                timesFormados.put(chave, new ArrayList<>());
            }

            List<String> jogadoresTime = timesFormados.get(chave);

            boolean sobrenomeJaNoTime = jogadoresTime.stream()
                .map(nome -> nome.split(" ")[1])
                .anyMatch(s -> s.equals(sobrenome));

            if (!sobrenomeJaNoTime) {
                jogadoresTime.add(jogador);
            } else {
                String novoGrupo = chave + "_" + sobrenome + i;
                timesFormados.computeIfAbsent(novoGrupo, k -> new ArrayList<>()).add(jogador);
                i++;
            }
        }

        timesFormados.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });

        return timesFormados;
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
