package simstation;

abstract public class MobileAgent extends Agent {
    Heading heading;

    public MobileAgent(String name) {
        super(name);
        turn(Heading.random()); // Start with random heading
    }

    @Override
    abstract public void update() throws InterruptedException;

    public void move(int steps) throws InterruptedException { //moves agent specified steps in the heading direction
        if(heading == Heading.EAST) {
            for (int i = 0; i < steps; i++) {
                xc += 1;
                if (xc > world.SIZE) xc -= world.SIZE;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.WEST){
            for(int i = 0; i < steps; i++){
                xc -= 1;
                if (xc < 0) xc += world.SIZE;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.NORTH){
            for(int i = 0; i < steps; i++){
                yc -= 1;
                if (yc < 0) yc += world.SIZE;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.SOUTH){
            for(int i = 0; i < steps; i++){
                yc += 1;
                if (yc > world.SIZE) yc -= world.SIZE;
                world.changed();
                Thread.sleep(20);
            }
        }
    }

    public void  turn(Heading heading){  //changes heading direction
        this.heading = heading;
    }

    public Heading getHeading() {
        return heading;
    }
}