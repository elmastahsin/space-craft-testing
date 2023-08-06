package com.company.spacecraft.model.response;

import com.company.spacecraft.entity.Player;
import com.company.spacecraft.entity.Target;
import lombok.Data;

import java.util.Set;

@Data
public class CreateHitResponse {
    private String responseMessage;
    private Boolean isEnded = false;
    private Boolean isWin = false;
    private Player player;
    private Set<Target> targets;
    private Long gameId;
}
