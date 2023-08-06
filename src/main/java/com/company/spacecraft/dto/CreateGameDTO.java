package com.company.spacecraft.dto;

import com.company.spacecraft.enumtype.Boost;
import com.company.spacecraft.enumtype.Level;
import lombok.Data;

@Data
public class CreateGameDTO {
    private String username;
    private Level level;
    private Boost boost;
}
