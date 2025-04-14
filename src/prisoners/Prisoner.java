package prisoners;

import simstation.*;
import java.util.Iterator;

public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private Strategy strategy;
    private World myWorld; // store a reference to the world manually

    public Prisoner(World world, Strategy strategy) {
        super(); // must call default constructor
        this.strategy = strategy;
        this.myWorld = world;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        Prisoner partner = findRandomNeighbor(10); // radius 10
        if (partner != null) {
            boolean myMove = this.cooperate();
            boolean partnerMove = partner.cooperate();

            if (myMove && partnerMove) {
                fitness += 3;
                partner.fitness += 3;
            } else if (myMove && !partnerMove) {
                fitness += 0;
                partner.fitness += 5;
            } else if (!myMove && partnerMove) {
                fitness += 5;
                partner.fitness += 0;
            } else {
                fitness += 1;
                partner.fitness += 1;
            }

            strategy.setCheated(!partnerMove);
            partner.strategy.setCheated(!myMove);
        }
    }

    private Prisoner findRandomNeighbor(int radius) {
        Iterator<Agent> it = myWorld.iterator();
        while (it.hasNext()) {
            Agent a = it.next();
            if (a != this && a instanceof Prisoner) {
                double dx = this.xc - a.xc;
                double dy = this.yc - a.yc;
                double distance = Math.sqrt(dx * dx + dy * dy);
                if (distance <= radius) {
                    return (Prisoner) a;
                }
            }
        }
        return null;
    }

    public int getFitness() {
        return fitness;
    }

    public String getStrategyName() {
        return strategy.getClass().getSimpleName();
    }
}
