package plague;

import mvc.*;
import simstation.WorldFactory;

public class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public View makeView(Model model) {
        return new PlagueView(model);
    }

    @Override
    public String getTitle() {
        return "Plague";
    }

    @Override
    public String[] getHelp() {
        return new String[] {
                "Start - Start the simulation",
                "Stop - Stop the simulation",
                "Resume - Resume the simulation",
                "Pause - Pause the simulation",
                "Stats - Display infection statistics",
                "Use sliders to adjust simulation parameters"
        };
    }

    @Override
    public String about() {
        return "Plague Simulation v1.0\nA simulation of disease spread through a population.";
    }
}