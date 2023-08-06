package com.company.spacecraft.service.impl;

import com.company.spacecraft.dto.CreateGameDTO;
import com.company.spacecraft.entity.Game;
import com.company.spacecraft.entity.Player;
import com.company.spacecraft.entity.Target;
import com.company.spacecraft.repository.GameRepository;
import com.company.spacecraft.service.CreateGameService;
import com.company.spacecraft.service.CreatePlayerService;
import com.company.spacecraft.service.CreateTargetService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Set;

@Service
public class CreateGameServiceImpl implements CreateGameService {

    private final CreatePlayerService createPlayerService;
    private final CreateTargetService createTargetService;

    private final GameRepository gameRepository;


    public CreateGameServiceImpl(
            CreatePlayerService createPlayerService,
            CreateTargetService createTargetService,
            GameRepository gameRepository
    ) {
        this.createPlayerService = createPlayerService;
        this.createTargetService = createTargetService;
        this.gameRepository = gameRepository;
    }

    @Override
    @Transactional
    public Long createGame(CreateGameDTO createGameDTO) {
        if (Objects.isNull(createGameDTO.getBoost())) {
            throw new RuntimeException("Game Boost type must not null");
        }

        if (Objects.isNull(createGameDTO.getLevel())) {
            throw new RuntimeException("Game Level type must not null");
        }

        final Game game = new Game();
        game.setBoost(createGameDTO.getBoost());
        game.setLevel(createGameDTO.getLevel());

        final Player player = createPlayerService.createPlayer(createGameDTO);
        game.setPlayer(player);
        player.setGame(game);

        final Set<Target> targets = createTargetService.createTargets(createGameDTO.getLevel());
        targets.forEach(target -> target.setGame(game));
        game.setTargets(targets);

        final Game saved = gameRepository.save(game);
        return saved.getId();
    }
}
