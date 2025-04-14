package prisoners;

import simstation.*;
import mvc.Model;

public class PrisonersDilemmaFactory extends WorldFactory {
	
	@Override
	public Model makeModel() {
	    return new PrisonersDilemmaSimulation();
	}

    

    @Override
    public String getTitle() {
        return "Prisoner's Dilemma";
    }
}
