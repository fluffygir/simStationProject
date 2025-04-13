package plague;

import mvc.AppPanel;
import simstation.Agent;
import simstation.World;

import java.util.Iterator;

public class PlagueSimulation extends World {
    public static int INITIAL_INFECTED = 10; // % agents start infected
    public static int POP_SIZE = 50;        // total number of agents
    public static int RECOVERY_TIME = 200;  // default recovery/fatality time
    public static int VIRULENCE = 50;       // % chance to infect on contact
    public static int RESISTANCE = 2;       // % chance to resist infection

    private boolean fatal = true;          // Whether the infection is fatal

    public PlagueSimulation() {
        super();
        SIZE = 500; // Set world size
    }

    public void setFatal(boolean fatal) {
        this.fatal = fatal;
    }

    public boolean isFatal() {
        return fatal;
    }

    @Override
    public void populate() {
        for (int i = 0; i < POP_SIZE; i++) {
            Plague agent = new Plague();
            agent.setFatal(fatal);

            // Set initial infection status based on INITIAL_INFECTED percentage
            if (Math.random() * 100 < INITIAL_INFECTED) {
                agent.setInfected(true);
            }

            addAgent(agent);
        }
    }

    @Override
    public String getStatus() {
        // Calculate current infection percentage
        int total = 0;
        int infected = 0;

        Iterator<Agent> it = iterator();
        while (it.hasNext()) {
            Agent agent = it.next();
            if (agent instanceof Plague) {
                total++;
                if (((Plague) agent).isInfected()) {
                    infected++;
                }
            }
        }

        double percentInfected = (total > 0) ? (infected * 100.0) / total : 0;

        return "#agents = " + total +
                "\nclock = " + clock +
                "\n% infected = " + String.format("%.1f", percentInfected);
    }

    public static void main(String[] args) {
        AppPanel panel = new PlaguePanel(new PlagueFactory());
        panel.display();
    }
}