package simstation;

public class ObserverAgent extends Agent {

    public ObserverAgent() {
        super();
    }

    @Override
    public void update() { //calls world.updateStatistics;
        world.updateStatistics();
    }
}
