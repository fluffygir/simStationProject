package simstation;

import mvc.Model;
import mvc.View;

import java.awt.*;

public class WorldView extends View {

    public WorldView(Model model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    public void drawAgents(Agent a, Graphics gc){

    }
}
