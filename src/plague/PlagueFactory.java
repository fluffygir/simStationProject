// PlagueFactory.java
package plague;

import mvc.*;
import simstation.WorldFactory;

public class PlagueFactory extends WorldFactory {
    @Override
    public Model makeModel() {
        return new PlagueSimulation();
    }

    @Override
    public String getTitle() {
        return "Plague Simulation";
    }
}