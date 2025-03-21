package com.t13g05.survivor.viewer.game;

import com.t13g05.survivor.gui.GUI;
import com.t13g05.survivor.model.game.arena.Arena;
import com.t13g05.survivor.model.game.element.Element;
import com.t13g05.survivor.viewer.Viewer;


import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getSurvivor(), new SurvivorViewer());
        drawElements(gui, getModel().getMonsters(), new MonsterViewer());
        drawElements(gui, getModel().getProjectiles(), new ProjectileViewer());

        // Health indicator
        gui.drawText(0, getModel().getHeight()-1, getModel().getSurvivor().getHealth() + "HP", "#ff5445");

        // Damage and fire rate display
        String statsDisplay = "DMG: " + (getModel().getSurvivor().getDamage()+getModel().getSurvivor().getWeapon().getBaseDamage()) +
                "  FR: " + String.format("%.2f", 1000/(float)(getModel().getSurvivor().getWeapon().getDelay() - getModel().getSurvivor().getFireRateReduction()));
        gui.drawText(getModel().getWidth() - statsDisplay.length(), getModel().getHeight()-1, statsDisplay, "#54f54e");

        // Level and experience indicator
        gui.drawText(0, 0,
                "Level: " + getModel().getSurvivor().getLevel() +
                        " (" + getModel().getSurvivor().getExperience() +
                        "/" + getModel().getSurvivor().necessaryExp() + ")",
                  "#5c54eb");

        // Ability cooldown display
        gui.drawText(getModel().getWidth()-15, 0,
                (getModel().getSurvivor().getAbility().getCooldown() == 0) ?
                        "Ability: Ready!" : "Ability: " + getModel().getSurvivor().getAbility().getCooldown(),
                    "#ff5445");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
