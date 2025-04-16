package Greed;

import simstation.*;
import java.awt.*;
import javax.swing.*;

public class Cow extends MobileAgent {
    public static final int MAX_ENERGY = 100;
    private int energy;
    private int greediness;
    private boolean alive = true;
    private Meadow meadow;

    public Cow(Meadow meadow) {
        super();
        this.energy = MAX_ENERGY;
        this.greediness = Meadow.getUserGreediness();
        this.meadow = meadow;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public void update() {
        if (!alive) return;

        Patch patch = meadow.getPatch(xc, yc);

        if (patch.getEnergy() >= greediness) {
            patch.reduceEnergy(greediness);
            energy = Math.min(MAX_ENERGY, energy + greediness);
        } else if (energy >= Meadow.moveEnergy) {
            // Move to a random nearby patch
            move(10); // Move 10 units in heading direction
            energy -= Meadow.moveEnergy;
        } else {
            energy -= Meadow.waitPenalty;
        }

        if (energy <= 0) {
            alive = false;
        }
    }

}
