package com.company.spacecraft.unit.service;

import com.company.spacecraft.dto.CreateHitDTO;
import com.company.spacecraft.entity.Game;
import com.company.spacecraft.entity.Player;
import com.company.spacecraft.entity.Target;
import com.company.spacecraft.enumtype.AttackType;
import com.company.spacecraft.repository.GameRepository;
import com.company.spacecraft.service.impl.CreateHitServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateHitServiceImplTest {

    private CreateHitServiceImpl createHitService;

    @Mock
    private GameRepository gameRepository;

    @BeforeEach
    public void setUp() {
        createHitService = new CreateHitServiceImpl(gameRepository);
    }


}
