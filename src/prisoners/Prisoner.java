package prisoners;

import simstation.*;

public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private Strategy strategy;

    public Prisoner(String name, Strategy strategy) {
        super(name); 
        this.strategy = strategy;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() {
        Prisoner partner = (Prisoner)((World) world).getNeighbors(this, 10); 
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

    public int getFitness() {
        return fitness;
    }

    public String getStrategyName() {
        return strategy.getClass().getSimpleName();
    }
}
