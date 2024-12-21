package com.t13g05.survivor.model.game.ability;

import com.t13g05.survivor.model.game.element.entity.Survivor;

public class WarriorAbility extends Ability {
    private final long duration;
    private long endTime;
    private int originalDamage;

    public WarriorAbility(long duration, long cooldown) {
        super(cooldown);
        this.duration = duration;
    }

    @Override
    public void use(Survivor survivor) {
        if (onCooldown()) return;

        startCooldown();
        endTime = System.currentTimeMillis() + duration;
        originalDamage = survivor.getDamage();
        survivor.setDamage(originalDamage * 2);
    }

    @Override
    public void update(Survivor survivor, long time) {
        if (System.currentTimeMillis() > endTime) {
            survivor.setDamage(originalDamage);
        }
    }
}
