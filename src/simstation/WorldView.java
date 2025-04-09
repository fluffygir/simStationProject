package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;
import java.util.Iterator;

public class WorldView extends View {

    public WorldView(Model model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        Graphics2D gc = (Graphics2D) g; // Cast to Graphics2D for advanced features

        World world = (World) model; // Get the World model
        Iterator<Agent> iter = world.iterator(); // Access agents in the world

        // Iterate over all agents and draw them
        while (iter.hasNext()) {
            Agent agent = iter.next();
            drawAgents(agent, gc); // Call drawAgents on each agent
        }


    }

    public void drawAgents(Agent a, Graphics gc){
        gc.setColor(Color.RED); // Set color to red
        int size = 10; // Agent size (diameter of the circle)
        gc.fillOval(a.xc- size / 2, a.yc - size / 2, size, size); // Draw centered circle



    }
}