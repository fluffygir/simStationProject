package greed;

import simstation.*;


public class Cow extends MobileAgent {
    public static final int MAX_ENERGY = 100;
    private int energy;
    private int greediness;
    private boolean alive = true;
    private Meadow meadow;

    public Cow(Meadow meadow) {
        super("Cow");
        this.energy = 100;  // Fixed to 100
        this.greediness = 25;  // Fixed to 25
        this.meadow = meadow;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public void update() throws InterruptedException {
        if (!alive) return;

        Patch patch = meadow.getPatch(xc, yc);
        if (patch == null) return;

        if (patch.getEnergy() >= greediness) {
            try {
                // Try to eat from the patch
                int eaten = patch.eatMe(this, greediness);
                energy = Math.min(MAX_ENERGY, energy + eaten);
            } catch (InterruptedException e) {
                throw e;
            }
        } else if (energy >= Meadow.moveEnergy) {
            // Move to a random nearby patch
            move(10); // Move 10 units in heading direction
            energy -= Meadow.moveEnergy;
        } else {
            // Not enough energy to move, must try to eat anyway
            try {
                // This will make the cow wait if there's insufficient energy
                int eaten = patch.eatMe(this, greediness);
                energy = Math.min(MAX_ENERGY, energy + eaten);
            } catch (InterruptedException e) {
                throw e;
            }
            energy -= Meadow.waitPenalty;
        }

        if (energy <= 0) {
            alive = false;
        }
    }
}