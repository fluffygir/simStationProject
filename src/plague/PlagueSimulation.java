package plague;

import mvc.AppPanel;
import simstation.World;

public class PlagueSimulation extends World {
    public static boolean IS_FATAL = false ;
    public static int INITIAL_INFECTED = (int)(Math.random()*100); // % agents start infected
    public static int POP_SIZE         = (int)(Math.random()*200); // total number of agents
    public static int RECOVERY_TIME = (int)(Math.random()*500);;  // default recovery/fatality time
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