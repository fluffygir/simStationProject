package plague;

import simstation.Agent;
import simstation.Heading;
import simstation.MobileAgent;

public class Plague extends MobileAgent {
    private boolean infected;

    public Plague() {
        super("Plague");
        infected = false;
    }

    public void setInfected(boolean status) {
        infected = status;
    }

    public boolean isInfected() {
        return infected;
    }

    public void infect() {

        if (Math.random() * 100 >= PlagueSimulation.RESISTANCE) {
            infected = true;
            world.changed();
        }
    }

    @Override
    public void update() throws InterruptedException {

        move(5);

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