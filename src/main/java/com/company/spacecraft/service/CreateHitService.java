package com.company.spacecraft.service;

import com.company.spacecraft.dto.CreateHitDTO;
import com.company.spacecraft.entity.Game;

public interface CreateHitService {
    Game createHit(CreateHitDTO createHitDTO);
}
