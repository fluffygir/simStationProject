package prisoners;

import mvc.*;

import simstation.Agent;
import simstation.World;
import simstation.WorldView;

import java.awt.*;
import java.util.Iterator;

public class PrisonersDilemmaView extends WorldView {
    public PrisonersDilemmaView(Model model) {
        super(model);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gc = (Graphics2D) g;
        World world = (World) model;
        Iterator<Agent> prisonerIterator = world.iterator();
        while (prisonerIterator.hasNext()) {
            Agent agent = prisonerIterator.next();
            if (agent instanceof Prisoner prisonerAgent) {
                gc.setColor(getAgentColor(prisonerAgent));
                int size = 10;
                gc.fillOval(prisonerAgent.xc - size / 2, prisonerAgent.yc - size / 2, size, size);
            }

        }
    }
    private Color getAgentColor(Prisoner prisoner) {
        String strategy = prisoner.getStrategyName();
        return switch (strategy) {
            case "Cooperate" -> Color.GREEN;
            case "Cheat" -> Color.RED;
            case "RandomlyCooperate" -> Color.BLUE;
            case "Tit4Tat" -> Color.ORANGE;
            default -> Color.BLACK;
        };
    }
}
