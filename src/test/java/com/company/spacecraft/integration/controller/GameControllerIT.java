package com.company.spacecraft.integration.controller;

import com.company.spacecraft.entity.Game;
import com.company.spacecraft.entity.Player;
import com.company.spacecraft.entity.Target;
import com.company.spacecraft.enumtype.AttackType;
import com.company.spacecraft.enumtype.Boost;
import com.company.spacecraft.enumtype.Level;
import com.company.spacecraft.model.request.CreateGameRequest;
import com.company.spacecraft.model.request.CreateHitRequest;
import com.company.spacecraft.model.response.CreateGameResponse;
import com.company.spacecraft.model.response.CreateHitResponse;
import com.company.spacecraft.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class GameControllerIT {
}
