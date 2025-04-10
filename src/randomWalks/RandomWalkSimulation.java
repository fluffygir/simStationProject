package randomWalks;


import mvc.*;
import simstation.*;

class Drunk extends MobileAgent {

    public Drunk() {
        super("Drunk");
    }

    public void update() throws InterruptedException {
        Heading heading = Heading.random();
        int steps = Utilities.rng.nextInt(20) + 1;
        move(steps);
    }

}


class RandomWalkFactory extends WorldFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks";}
}

public class RandomWalkSimulation extends World {

    public void populate() {
        for (int i = 0; i < 50; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new WorldPanel(new RandomWalkFactory());
        panel.display();
    }

}