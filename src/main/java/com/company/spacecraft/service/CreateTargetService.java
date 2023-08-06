package com.company.spacecraft.service;

import com.company.spacecraft.entity.Target;
import com.company.spacecraft.enumtype.Level;

import java.util.Set;

public interface CreateTargetService {
    Set<Target> createTargets(Level level);
}
