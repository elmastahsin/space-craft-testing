package com.company.spacecraft.converter;

import com.company.spacecraft.dto.CreateGameDTO;
import com.company.spacecraft.model.request.CreateGameRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateGameRequestToCreateGameDtoConverter implements Converter<CreateGameRequest, CreateGameDTO> {
    @Override
    public CreateGameDTO convert(CreateGameRequest source) {
        final CreateGameDTO createGameDTO = new CreateGameDTO();
        createGameDTO.setUsername(source.getUsername());
        createGameDTO.setBoost(source.getBoost());
        createGameDTO.setLevel(source.getLevel());
        return createGameDTO;
    }
}
