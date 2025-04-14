package plague;

import simstation.Agent;
import simstation.MobileAgent;
import simstation.Heading;



public class Plague extends MobileAgent {
    private boolean infected;
    private boolean dead;
    private int infectionTime = 0;
    private boolean fatal = true;

    public Plague() {
        super("Plague");
        infected = false;
        dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setInfected(boolean status) {
        infected = status;
        if (infected) {
            infectionTime = 0; // Reset infection time when newly infected
        }
    }

    public boolean isInfected() {
        return infected;
    }

    public void setFatal(boolean fatal) {
        this.fatal = fatal;
    }

    public boolean isFatal() {
        return fatal;
    }
    public void infect() {
        // Check if infection happens based on virulence
        if (Math.random() * 100 < PlagueSimulation.VIRULENCE) {
            // Resistance gives a chance to avoid infection
            if (Math.random() * 100 >= PlagueSimulation.RESISTANCE) {
                infected = true;
                infectionTime = 0;
            }
        }
    }

    @Override
    public void update() throws InterruptedException {
        if (dead || isStopped()) {
            return;
        }

        // Infection and movement logic
        if (Math.random() < 0.1) {
            turn(Heading.random());
        }
        move(5);

        if (infected) {
            infectionTime++;
            if (infectionTime >= PlagueSimulation.RECOVERY_TIME) {
                if (isFatal()) {
                    die(); // Causes the agent to "die"
                } else {
                    // Agent recovers
                    infected = false;
                }
            }

            // Attempt to infect neighbors
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor != null && neighbor instanceof Plague other) {
                if (!other.isInfected()) {
                    other.infect();
                }
            }
        }
    }

    private void die() {
        dead = true;       // Mark this agent as explicitly dead
        stop();
    }
}