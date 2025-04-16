package plague;

import mvc.Model;
import simstation.Agent;
import simstation.World;
import simstation.WorldView;

import java.awt.*;
import java.util.Iterator;

public class PlagueView extends WorldView {

    public PlagueView(Model model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gc = (Graphics2D) g;
        World world = (World) model;
        Iterator<Agent> iter = world.iterator();

        while (iter.hasNext()) {
            Agent agent = iter.next();
            if (agent instanceof Plague plagueAgent) {
                // Set color based on infection status
                if(plagueAgent.isDead()){
                    gc.setColor(Color.DARK_GRAY);
                } else if (plagueAgent.isInfected()) {
                    gc.setColor(Color.RED);
                } else {
                    gc.setColor(Color.GREEN);
                }

                // Draw the agent
                int size = 10;
                gc.fillOval(agent.xc - size/2, agent.yc - size/2, size, size);
            }
        }
    }
}