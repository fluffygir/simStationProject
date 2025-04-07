package simstation;

abstract public class MobileAgent extends Agent {
    Heading heading;

    public MobileAgent() {
        super();
        heading = Heading.EAST;
    }

    @Override
    abstract public void update();

    public void move(int steps) throws InterruptedException { //moves agent specified steps in the heading direction
        if(heading == Heading.EAST) {
            for (int i = 0; i < steps; i++) {
                xc += 1;
                if (xc > world.size) xc -= world.size;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.WEST){
            for(int i = 0; i < steps; i++){
                xc -= 1;
                if (xc < 0) xc += world.size;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.NORTH){
            for(int i = 0; i < steps; i++){
                yc -= 1;
                if (yc < 0) yc += world.size;
                world.changed();
                Thread.sleep(20);
            }
        } else if(heading == Heading.SOUTH){
            for(int i = 0; i < steps; i++){
                yc += 1;
                if (yc > world.size) yc -= world.size;
                world.changed();
                Thread.sleep(20);
            }
        }
    }

    public void turn(Heading heading){  //changes heading direction
        this.heading = heading;
    }
}
