package simstation;

import mvc.Model;

import java.util.Iterator;

public class World extends Model {
    int size = 500;
    int clock = 0;
    int alive = 0;

    public World() {

    }

    public void addAgent(Agent agent) {

    }
    public void startAgents() {
    }

    public void stopAgents() {
    }
    public void pauseAgents() {
    }
    public void resumeAgents() {
    }
    public void updateStatistics() {
    }
    public void populate(){
        for(int i = 0; i < 100; i++){
            addAgent(new MobileAgent());
        }
    }
    public String getStatus (){

        return "";
    }
    public void getNeighbors(Agent caller, int radius){

    }

    public Iterator<Agent> iterator() {
        return null;
    }
}
