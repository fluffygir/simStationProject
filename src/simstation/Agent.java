package simstation;

import mvc.Utilities;

import java.io.Serializable;

abstract public class Agent implements Runnable, Serializable {
    int xc;
    int yc;
    boolean paused, stopped;
    String agentName;
    transient protected Thread myThread;
    World world;

    public Agent(String name){
        this.myThread = null;
        this.agentName = name;
        this.world = null;
        this.paused = false;
        this.stopped = false;
        this.xc = Utilities.rng.nextInt(World.SIZE);
        this.yc = Utilities.rng.nextInt(World.SIZE);
    }

    public String getName() { return agentName; }
    public synchronized String toString() {
        String result = agentName;
        if (stopped) result += " (stopped)";
        else if (paused) result += " (paused)";
        else result += " (running)";
        return result;
    }

    // thread stuff
    public synchronized void start(){ stopped = false; }
    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void pause(){ paused = true; }
    public synchronized void resume() { notify(); }
    public synchronized boolean isPaused() { return paused; }
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage()); // changed from default code
        }
    }

    //wait for notification if I'm not stopped and I'm paused
    private synchronized void checkPaused() {
        try {
            while(!stopped && paused) {
                wait();
                paused = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        myThread = Thread.currentThread();
        onStart();
        checkPaused();
        while (!stopped) {
            try {
                update();
                onInterrupted();
                Thread.sleep(1000);
                checkPaused();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        onExit();
    }

    abstract public void update() throws InterruptedException;

    protected synchronized void onStart(){ }

    protected synchronized void onInterrupted(){ }

    protected synchronized void onExit(){ }
}