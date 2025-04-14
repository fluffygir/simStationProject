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
    
    public View makeView(Model m) {
        return new PrisonersDilemmaView(m);
    }

}
