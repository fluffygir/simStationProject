package plague;

import simstation.Agent;
import simstation.MobileAgent;
import simstation.Heading;

public class Plague extends MobileAgent {
    private boolean infected;
    private int infectionTime = 0;
    private boolean fatal = true;

    public Plague() {
        super("Plague");
        infected = false;
        turn(Heading.random()); // Start with random heading
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
        // Randomly change direction occasionally
        if (Math.random() < 0.1) {
            turn(Heading.random());
        }

        // Move agent
        move(5);

        // Handle infection logic
        if (infected) {
            // Increment infection time
            infectionTime++;

            // Check if recovery/death time has been reached
            if (infectionTime >= PlagueSimulation.RECOVERY_TIME) {
                if (fatal) {
                    // Agent dies (could implement removal logic here)
                    stop();
                } else {
                    // Agent recovers
                    infected = false;
                }
            }

            // Try to infect neighbors
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor != null && neighbor instanceof Plague) {
                Plague other = (Plague) neighbor;
                if (!other.isInfected()) {
                    other.infect();
                }
            }
        }

        Thread.sleep(20);
    }
}