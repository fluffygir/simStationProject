package simstation;

public class ObserverAgent extends Agent {

    public ObserverAgent(String name) {
        super(name);
    }

    @Override
    public void update() { //calls world.updateStatistics;
        world.updateStatistics();
    }
}