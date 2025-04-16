package prisoners;

import mvc.Utilities;
import simstation.*;


public class Prisoner extends MobileAgent {
    private int fitness = 0;
    private Strategy strategy;
    private World myWorld; // store a reference to the world manually

    public Prisoner(World world, Strategy strategy) {
        super("Prisoner");

        this.strategy = strategy;
        this.myWorld = world;
    }

    public boolean cooperate() {
        return strategy.cooperate();
    }

    public void update() throws InterruptedException {
        Prisoner partner = (Prisoner)myWorld.getNeighbor(this,10);
        if (partner != null) {
            boolean myMove = this.cooperate();
            boolean partnerMove = partner.cooperate();

            playGame(partner);
            strategy.setCheated(!partnerMove);
            partner.strategy.setCheated(!myMove);
        }
        turn(Heading.random());
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);

    }

    public void playGame( Prisoner partner) {
        boolean myMove = this.cooperate();
        boolean partnerMove = partner.cooperate();

        if (myMove && partnerMove) {
            fitness += 3;
            partner.fitness += 3;
        } else if (myMove) {
            partner.fitness += 5;
        } else if (partnerMove) {
            fitness += 5;
        } else {
            fitness += 1;
            partner.fitness += 1;
        }
    }
    public int getFitness() {
        return fitness;
    }

    public String getStrategyName() {
        return strategy.getClass().getSimpleName();
    }
}