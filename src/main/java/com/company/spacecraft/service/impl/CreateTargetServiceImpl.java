package com.company.spacecraft.service.impl;

import com.company.spacecraft.entity.Target;
import com.company.spacecraft.enumtype.Level;
import com.company.spacecraft.service.CreateTargetService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CreateTargetServiceImpl implements CreateTargetService {
    private static final int DEFAULT_HEALTH = 233;
    private static final int DEFAULT_ARMOR = 7;
    private static final int SHOOT_POWER = 10;

    @Override
    public Set<Target> createTargets(Level level) {
        int targetCount = 1;
        int targetHealthParity = 1;
        int armorParity = 1;
        int shootPowerParity = 1;
        switch (level) {
            case EASY:
                break;
            case MEDIUM:
                targetCount = 3;
                targetHealthParity = 4;
                armorParity = 43;
                break;
            case HARD:
                targetCount = 4;
                targetHealthParity = 5;
                armorParity = 83;
                shootPowerParity = 100;
                break;
            default:
                throw new RuntimeException("Level type must be valid");
        }
        final int finalTargetHealthParity = targetHealthParity;
        final int finalArmorParity = armorParity;
        final int finalShootPowerParity = shootPowerParity;
        return IntStream.range(0, targetCount)
                .mapToObj(index -> {
                    final Target target = new Target();
                    target.setHealth(DEFAULT_HEALTH * finalTargetHealthParity);
                    target.setArmor(DEFAULT_ARMOR * finalArmorParity);
                    target.setShootPower(SHOOT_POWER * finalShootPowerParity);
                    return target;
                }).collect(Collectors.toSet());
    }
}
