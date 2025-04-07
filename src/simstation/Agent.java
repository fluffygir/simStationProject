package simstation;

import java.io.Serializable;

abstract public class Agent implements Runnable, Serializable {
    int xc;
    int yc;
    boolean paused, stopped;
    String agentName;
    transient protected Thread myThread;
    World world;

    public Agent(){
        this.myThread = null;
        this.agentName = null;
        this.world = null;
        this.paused = false;
        this.stopped = false;
        this.xc = 0;
        this.yc = 0;
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

    //wait for notification if I'm not stopped and I'm suspended
    private synchronized void checkSuspended() {
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
        while (!stopped) {
            try {
                onStart();                  //unsure about placement of on___ methods
                update();
                onInterrupted();
                Thread.sleep(1000);
                checkSuspended();
                onExit();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    abstract public void update();

    public void onStart(){ }

    public void onInterrupted(){ }

    public void onExit(){ }
}
