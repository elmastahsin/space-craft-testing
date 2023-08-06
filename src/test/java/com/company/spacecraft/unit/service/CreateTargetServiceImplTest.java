package com.company.spacecraft.unit.service;

import com.company.spacecraft.entity.Target;
import com.company.spacecraft.enumtype.Level;
import com.company.spacecraft.service.impl.CreateTargetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreateTargetServiceImplTest {

   private CreateTargetServiceImpl createTargetService;

   @BeforeEach
    public void setUp(){
         createTargetService = new CreateTargetServiceImpl();
    }

    @Test
    public void should_create_target_with_level_easy(){
        // given
        Level level = Level.EASY;

        //when
        Set<Target> targets = createTargetService.createTargets(level);

        //then
        Target target = targets.stream().findFirst().get();
        assertEquals(targets.size(),1);
        assertEquals(target.getHealth(),233);
        assertEquals(target.getArmor(),7);
        assertEquals(target.getShootPower(), 10);
   }
   @Test
    public void should_create_target_with_level_medium(){
        // given
        Level level = Level.MEDIUM;

        //when
        Set<Target> targets = createTargetService.createTargets(level);

        //then
        Target target = targets.stream().findFirst().get();
        assertEquals(targets.size(),3);
        assertEquals(target.getHealth(),932);
        assertEquals(target.getArmor(),301);
        assertEquals(target.getShootPower(), 10);
   }
   @Test
    public void should_create_target_with_level_hard(){
        // given
        Level level = Level.HARD;

        //when
        Set<Target> targets = createTargetService.createTargets(level);

        //then
        Target target = targets.stream().findFirst().get();
        assertEquals(targets.size(),4);
        assertEquals(target.getHealth(),1165);
        assertEquals(target.getArmor(),581);
        assertEquals(target.getShootPower(), 1000);
   }
}
