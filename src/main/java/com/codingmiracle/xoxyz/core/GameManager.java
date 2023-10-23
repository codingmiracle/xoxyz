package com.codingmiracle.xoxyz.core;

import com.codingmiracle.xoxyz.Models.GameDto;

import java.util.HashSet;
import java.util.Set;

public class GameManager {

    Set<GameDto> activeGameDtos;
    public GameManager() {
        activeGameDtos = new HashSet<GameDto>();
    }

    public boolean startGame(GameDto gameDto) {
        //check if game is full
        //
        return true;
    }


}
