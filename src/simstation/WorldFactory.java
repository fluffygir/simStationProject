package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;



public class WorldFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new World();
    }

    @Override
    public View makeView(Model model) {
        return new WorldView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[]{"Start", "Stop", "Resume", "Pause", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return switch (type) {
            case "Start" -> new StartCommand(model);
            case "Stop" -> new StopCommand(model);
            case "Resume" -> new ResumeCommand(model);
            case "Pause" -> new SuspendCommand(model);
            case "Stats" -> new StatsCommand(model);
            default -> null;
        };
    }

    @Override
    public String getTitle() {
        return "Sim Station";
    }

    @Override
    public String[] getHelp() {
        return new String[]{ "Start - Start the simulation","Stop - Stop the simulation", "Resume - Resume the simulation", "Pause - Pause the simulation", "Stats - Display statistics"};
    }

    @Override
    public String about() {
        return "SimStation version 1.0. Copyright 2025 by Naina Talasu, Ryan Nikopour, & Nathaniel Fadrigon";
    }
}
