package simstation;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;
import mvc.View;



public class WorldFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return null;
    }

    @Override
    public View makeView(Model model) {
        return null;
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        return null;
    }

    @Override
    public String getTitle() {
        return "";
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return "";
    }
}
