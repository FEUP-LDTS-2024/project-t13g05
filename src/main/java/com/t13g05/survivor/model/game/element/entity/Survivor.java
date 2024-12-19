package com.t13g05.survivor.model.game.element.entity;

import com.t13g05.survivor.gui.LanternaGUI;
import com.t13g05.survivor.model.Position;
import com.t13g05.survivor.model.weapon.Weapon;

public class Survivor extends Entity {
    Weapon weapon;
    Position direction = new Position(1, 0);
    int fireRateReduction;
    int level;
    int experience;

    public Survivor(Position position, int health, String weapon) {
        super(position, health);
        try {
            this.weapon = (Weapon) Class.forName("com.t13g05.survivor.model.weapon." + weapon).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.level = 0;
        this.experience = 0;
        this.fireRateReduction = 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Position getDirection() {
        return direction;
    }

    public void setDirection(Position direction) {
        this.direction = direction;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public int necessaryExp() {
        return level*20 + 100;
    }

    public void giveExperience(int experience) {
        this.experience += experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void levelUp() {
        this.level++;
    }

    public int getFireRateReduction() {
        return fireRateReduction;
    }


    public void upFireRate() {
        this.fireRateReduction = getFireRateReduction() + 40;
    }

    public void upHealth() {
        this.health = getHealth() + 50;
    }

    public void upDamage(){
        this.damage = getDamage() + weapon.getBaseDamage();
    }
}
