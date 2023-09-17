package com.teamdrawer.teamdrawerapi.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GeraTimes {
    public static Map<String, List<String>> organizarTimes(List<String> jogadores) {
    
        Map<String, List<String>> timesFormados = new HashMap<>();
        int i = 1;

        for (String jogador : jogadores) {
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
}
