package com.company.spacecraft.service;

import com.company.spacecraft.dto.CreateGameDTO;
import com.company.spacecraft.entity.Player;

public interface CreatePlayerService {
    Player createPlayer(CreateGameDTO createGameDTO);
}
