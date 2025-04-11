package plague;

import simstation.Agent;
import simstation.Heading;
import simstation.MobileAgent;

public class Plague extends MobileAgent {
    private boolean infected;

    public Plague() {
        super("Plague");
        infected = false;  // initial infection set in populate()
    }

    public void setInfected(boolean status) {
        infected = status;
    }

    public boolean isInfected() {
        return infected;
    }

    public void infect() {
        // Resistance gives a chance to avoid infection
        if (Math.random() * 100 >= PlagueSimulation.RESISTANCE) {
            infected = true;
        }
    }

    @Override
    public void update() throws InterruptedException {

        move(5);  // inherited from MobileAgent

        // if infected, attempt to infect a nearby agent
        if (infected) {
            Agent neighbor = world.getNeighbor(this, 10);
            if (neighbor != null) {
                Plague other = (Plague) neighbor;
                if (!other.isInfected()) {
                    other.infect();  // uses RESISTANCE internally
                }
            }
        }

        Thread.sleep(20);
    }
}