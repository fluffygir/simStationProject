package prisoners;

import simstation.*;
import mvc.Model;
import mvc.View;

public class PrisonersDilemmaFactory extends WorldFactory {

    @Override
    public Model makeModel() {
        return new PrisonersDilemmaSimulation();
    }

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma";
    }

    @Override
    public String[] getHelp() {
        return new String[]{"Start - Start the simulation","Stop - Stop the simulation", "Resume - Resume the simulation", "Pause - Pause the simulation", "Stats - Display statistics", "Use sliders to adjust simulation parameters"};
    }
    @Override
    public String about() {
        return "Prisoner's Dilemma Simulation - A simulation of the Prisoner's Dilemma." + "\n" + super.about();
    }
    @Override
    public View makeView(Model m) {
        return new PrisonersDilemmaView(m);
    }

}