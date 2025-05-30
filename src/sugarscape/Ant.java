package sugarscape;

import simstation.*;
import java.awt.*;
import java.util.*;
import mvc.*;



class SugarPod {

    private int xc, yc;

    public SugarPod(int xc, int yc) {
        super();
        this.xc = xc;
        this.yc = yc;
    }

    public int getXc() { return xc; }
    public int getYc() { return yc; }
    public void setXc(int xc) { this.xc = xc; }
    public void setYc(int xc) { this.yc = yc; }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + xc;
        result = prime * result + yc;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SugarPod other = (SugarPod) obj;
        if (xc != other.xc) return false;
        if (yc != other.yc) return false;
        return true;
    }
}


public class Ant extends MobileAgent {
    private int health = 3;

    public Ant(){
       super("");

    }
    public Ant(String name) {
        super(name);
    }


    public synchronized int getHealth() {
        return health;
    }
    public synchronized void setHealth(int health) {
        this.health = health;
    }

    public void update() throws InterruptedException {
        SugarScape ss = (SugarScape)world;
        SugarPod loc = new SugarPod(xc, yc);
        synchronized(ss) {
            if (ss.contains(new SugarPod(xc, yc))) {
                ss.remove(loc);
                health = health + 5;
                System.out.println("yum!");
            }
        }
        heading = Heading.random();
        move(health + 10);
    }
}

class SugarScapeView extends View {
    public SugarScapeView(Model model) {
        super(model);
    }

    protected void drawAgent(Agent a, Graphics gc) {
        gc.setColor(Color.RED);
        Ant ant = (Ant)a;
        gc.fillOval(ant.xc, ant.yc, ant.getHealth() + 3, ant.getHealth() + 3);
    }

    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        SugarScape sim = (SugarScape)model;
        synchronized(sim) {
            Iterator<SugarPod> it1 = sim.podIterator();
            gc.setColor(Color.BLACK);
            while(it1.hasNext()) {
                SugarPod p = it1.next();
                gc.fillOval(p.getXc(), p.getYc(), 4, 4);
            }
            Iterator<Agent> it = sim.iterator();
            gc.setColor(Color.RED);
            while(it.hasNext()) {
                drawAgent(it.next(), gc);
            }
        }
        gc.setColor(oldColor);
    }
}
class SugarScapeFactory extends WorldFactory {
    public Model makeModel() { return new SugarScape(); }
    public View makeView(Model model) { return new SugarScapeView(model); }
    @Override
    public String getTitle() {
        return "SugarScape";
    }
}
