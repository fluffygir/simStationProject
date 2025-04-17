package greed;

public class Patch {
    public static final int MAX_ENERGY = 100;
    private int energy;
    static int growBackRate = 1;
    public static int patchSize = 10;

    public Patch(int growBackRate, int patchSize) {
        this.energy = MAX_ENERGY;
        Patch.growBackRate = growBackRate;
        Patch.patchSize = patchSize;
    }

    public synchronized int getEnergy() {
        return energy;
    }

    public synchronized int eatMe(Cow cow, int greediness) throws InterruptedException {
        while (energy < greediness) {
            wait(); // Wait until notified

            if (Thread.currentThread().isInterrupted()) {
                return 0;
            }
        }

        int eaten = Math.min(greediness, energy);
        energy -= eaten;
        return eaten;
    }

    public synchronized void update() {
        energy = Math.min(MAX_ENERGY, energy + growBackRate);
        notifyAll();
    }
}