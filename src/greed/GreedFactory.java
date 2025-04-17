package greed;

import greed.GreedView;
import simstation.*;
import mvc.*;

public class GreedFactory extends WorldFactory {
    public Model makeModel() {
        return new Meadow();
    }

    public View makeView(Model model) {
        return new GreedView(model);
    }


    public String getTitle() {
        return "Greed Simulation";
    }

    public String[] getHelp() {
        return new String[] {
                "Cows eat grass to survive.",
                "Grass regrows slowly.",
                "Cows move if patch has no food.",
                "Simulation ends when all cows die."
        };
    }

    public String about() {
        return "Greed Simulation - SimStation adaptation";
    }
}