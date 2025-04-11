// PlagueSimulation.java
package plague;

import mvc.AppPanel;
import simstation.World;

public class PlagueSimulation extends World {
    public static int INITIAL_INFECTED = 10; // % agents start infected
    public static int POP_SIZE         = 50; // total number of agents
    public static int RECOVERY_TIME = 200;  // default recovery/fatality time
    public static int VIRULENCE        = 50; // % chance to infect on contact
    public static int RESISTANCE       =  2; // % chance to resist infection

    @Override
    public void populate() {
        for (int i = 0; i < POP_SIZE; i++) {
            Plague agent = new Plague();
            if (Math.random() * 100 < INITIAL_INFECTED) {
                agent.setInfected(true);
            }
            addAgent(agent);
        }
    }

    public static void main(String[] args) {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}
