package com.company.spacecraft.model.request;

import com.company.spacecraft.enumtype.Boost;
import com.company.spacecraft.enumtype.Level;
import lombok.Data;

@Data
public class CreateGameRequest {
    private String username;
    private Level level;
    private Boost boost;
}
