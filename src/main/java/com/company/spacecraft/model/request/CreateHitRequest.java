package com.company.spacecraft.model.request;

import com.company.spacecraft.enumtype.AttackType;
import lombok.Data;

@Data
public class CreateHitRequest {
    private AttackType attackType;
    private Long gameId;
}
