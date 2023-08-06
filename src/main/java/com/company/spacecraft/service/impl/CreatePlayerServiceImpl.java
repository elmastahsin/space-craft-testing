package com.company.spacecraft.service.impl;

import com.company.spacecraft.dto.CreateGameDTO;
import com.company.spacecraft.entity.Player;
import com.company.spacecraft.service.CreatePlayerService;
import org.springframework.stereotype.Service;

@Service
public class CreatePlayerServiceImpl implements CreatePlayerService {
    private static final int DEFAULT_HEALTH = 2000;
    private static final int DEFAULT_ARMOR = 7;
    private static final int SHOOT_POWER = 10;

    @Override
    public Player createPlayer(CreateGameDTO createGameDTO) {
        int additionalArmor = 0;
        int additionalHealth = 0;
        int additionalPower = 0;

        switch (createGameDTO.getBoost()) {
            case SUPER_AMMO:
                additionalPower = 150;
                break;
            case BIG_BOMB:
                additionalPower = 5000;
                break;
            case EXTRA_SHIELD:
                additionalArmor = 235;
                additionalHealth = 2145;
                break;
            default:
                throw new RuntimeException("Boost type must be valid");
        }
        final Player player = new Player();
        player.setUsername(createGameDTO.getUsername());
        player.setArmor(DEFAULT_ARMOR + additionalArmor);
        player.setHealth(DEFAULT_HEALTH + additionalHealth);
        player.setShootPower(SHOOT_POWER + additionalPower);
        return player;
    }
}
