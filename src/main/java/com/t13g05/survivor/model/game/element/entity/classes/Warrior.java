package com.t13g05.survivor.model.game.element.entity.classes;

import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.game.ability.WarriorAbility;
import com.t13g05.survivor.model.game.element.entity.Survivor;

public class Warrior extends Survivor {
    public Warrior(Position position, String weapon) {
        super(position, 150, weapon, new WarriorAbility(5000, 30000));
        color = "#FF0000";
        character = "#";
    }
}
