package Greed;

public class Patch {
    public static final int MAX_ENERGY = 100;
    private int energy;
    static int growBackRate;
    private int patchSize;

    public Patch(int growBackRate, int patchSize) {
        this.energy = MAX_ENERGY;
        this.growBackRate = growBackRate;
        this.patchSize = patchSize;
    }

    public int getEnergy() {
        return energy;
    }
    
    public void reduceEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }


    public void growBack() {
        energy = Math.min(MAX_ENERGY, energy + growBackRate);
    }

    public int eatMe(Cow cow, int amount) {
        int eaten = Math.min(amount, energy);
        energy -= eaten;
        return eaten;
    }

    public int getPatchSize() {
        return patchSize;
    }

    public void update() {
        growBack();
    }
}
