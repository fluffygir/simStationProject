package plague;

import mvc.Model;
import simstation.Agent;
import simstation.World;
import simstation.WorldView;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class PlagueView extends WorldView {

    public PlagueView(Model model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Clear the screen with a white background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        PlagueSimulation simulation = (PlagueSimulation) getModel();

        // Iterate through all agents in the simulation
        Iterator<Agent> itr = simulation.iterator();
        while (itr.hasNext()) {
            // Cast each agent to a PlagueAgent to access specific properties
            Plague agent = (Plague) itr.next();

            // Use colors: RED for infected agents, GREEN for healthy agents
            g.setColor(agent.isInfected() ? Color.RED : Color.GREEN);

            int x = (int) ((agent.xc / (double) World.SIZE) * getWidth());
            int y = (int) ((agent.yc / (double) World.SIZE) * getHeight());

            // Draw the agent as a small circle
            g.fillOval(x, y, 10, 10);
        }
    }
}