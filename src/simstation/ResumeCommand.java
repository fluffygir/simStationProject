package simstation;

import mvc.Command;
import mvc.Model;

public class ResumeCommand extends Command {

    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        World world = (World) model;
        world.resumeAgents();

    }
}