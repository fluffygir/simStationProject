package plague;

import mvc.*;
import simstation.*;

public class PlagueFactory extends WorldFactory {
    public Model makeModel() {
        return new PlagueSimulation();
    }

    public String getTitle() {
        return "Plague Simulation";
    }
}

