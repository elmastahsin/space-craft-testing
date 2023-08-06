package com.company.spacecraft.controller;

import com.company.spacecraft.converter.CreateGameRequestToCreateGameDtoConverter;
import com.company.spacecraft.converter.CreateHitRequestToCreateHitDtoConverter;
import com.company.spacecraft.converter.GameToCreateHitResponseConverter;
import com.company.spacecraft.dto.CreateGameDTO;
import com.company.spacecraft.dto.CreateHitDTO;
import com.company.spacecraft.entity.Game;
import com.company.spacecraft.model.request.CreateGameRequest;
import com.company.spacecraft.model.request.CreateHitRequest;
import com.company.spacecraft.model.response.CreateGameResponse;
import com.company.spacecraft.model.response.CreateHitResponse;
import com.company.spacecraft.service.CreateGameService;
import com.company.spacecraft.service.CreateHitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(GameController.CONTROLLER_PATH)
@Slf4j
public class GameController {
    public static final String CONTROLLER_PATH = "/api/v1/game";

    private final CreateGameService createGameService;
    private final CreateGameRequestToCreateGameDtoConverter createGameRequestToCreateGameDtoConverter;
    private final CreateHitRequestToCreateHitDtoConverter createHitRequestToCreateHitDtoConverter;
    private final CreateHitService createHitService;
    private final GameToCreateHitResponseConverter gameToCreateHitResponseConverter;

    public GameController(
            CreateGameService createGameService,
            CreateGameRequestToCreateGameDtoConverter createGameRequestToCreateGameDtoConverter,
            CreateHitRequestToCreateHitDtoConverter createHitRequestToCreateHitDtoConverter,
            CreateHitService createHitService,
            GameToCreateHitResponseConverter gameToCreateHitResponseConverter) {
        this.createGameService = createGameService;
        this.createGameRequestToCreateGameDtoConverter = createGameRequestToCreateGameDtoConverter;
        this.createHitRequestToCreateHitDtoConverter = createHitRequestToCreateHitDtoConverter;
        this.createHitService = createHitService;
        this.gameToCreateHitResponseConverter = gameToCreateHitResponseConverter;
    }

    @PostMapping("/createGame")
    public CreateGameResponse createGame(@RequestBody CreateGameRequest createGameRequest) {
        final CreateGameResponse createGameResponse = new CreateGameResponse();
        try {
            final CreateGameDTO createGameDTO = createGameRequestToCreateGameDtoConverter.convert(createGameRequest);
            final Long gameId = createGameService.createGame(createGameDTO);
            createGameResponse.setGameId(gameId);
            createGameResponse.setResponseMessage("SUCCESS");
        } catch (Exception e) {
            log.error("Exception Occured", e);
            createGameResponse.setResponseMessage("FAILURE");
        }
        return createGameResponse;
    }


    @PostMapping("/createHit")
    public CreateHitResponse createHit(@RequestBody CreateHitRequest createHitRequest) {
        try {
            final CreateHitDTO createHitDTO = createHitRequestToCreateHitDtoConverter.convert(createHitRequest);
            final Game game = createHitService.createHit(createHitDTO);
            final CreateHitResponse createHitResponse = gameToCreateHitResponseConverter.convert(game);
            createHitResponse.setResponseMessage("SUCCESS");
            return createHitResponse;
        } catch (Exception e) {
            log.error("Exception Occured", e);
            final CreateHitResponse createHitResponse = new CreateHitResponse();
            createHitResponse.setResponseMessage("FAILURE");
            return createHitResponse;
        }

    }
}
