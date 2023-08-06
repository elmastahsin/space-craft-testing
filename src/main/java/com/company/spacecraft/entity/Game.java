package com.company.spacecraft.entity;

import com.company.spacecraft.enumtype.Boost;
import com.company.spacecraft.enumtype.Level;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
public class Game extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private Level level;
    @Enumerated(EnumType.STRING)
    private Boost boost;

    private Boolean isEnded = false;
    private Boolean isWin = false;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "game")
    private Player player;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private Set<Target> targets;
}
