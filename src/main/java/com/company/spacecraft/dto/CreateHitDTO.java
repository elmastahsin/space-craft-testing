package com.company.spacecraft.dto;

import com.company.spacecraft.enumtype.AttackType;
import lombok.Data;

@Data
public class CreateHitDTO {
    private AttackType attackType;
    private Long gameId;
}
