package simstation;


import mvc.Model;

import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Random;

public class World extends Model {
    static int SIZE;
    int clock;
    int alive;
    List<Agent> agentList;
    ObserverAgent observer;

    public World() {
        SIZE =500;
        clock = 0;
        alive = 0;
        agentList = new java.util.ArrayList<>();
        observer = new ObserverAgent("Observer");
    }

    public void addAgent(Agent agent) {
        agentList.add(agent);
        alive++;
        agent.world=this;
    }
    public void startAgents() {
        populate();
        for (Agent agent : agentList) {
            // Create and start a new thread for each agent
            Thread thread = new Thread(agent);
            agent.myThread = thread;
            thread.start();
            agent.start(); // Sets stopped = false
        }
    }

    public void stopAgents() {
        agentList.forEach(Agent::stop);
    }
    public void pauseAgents() {
        agentList.forEach(Agent::pause);
    }
    public void resumeAgents() {
        agentList.forEach(Agent::resume);
    }
    public void updateStatistics() {
        clock++;
        alive=0;
        // Iterate through all agents in the world to count active ones
        for (Agent agent : agentList) {
            if (!agent.paused||!agent.stopped) { // Check if the agent is currently active
                alive++;
            }
        }


    }
    public void populate(){

    }
    public String getStatus (){
        if (alive == 0) return "No agents alive";
        else {
            return alive + " agents alive";
        }
    }
    public Agent getNeighbor(Agent caller, int radius) {
        if (agentList.isEmpty()) return null; // Safeguard for empty list

        Random random = new Random();
        int startIndex = random.nextInt(agentList.size()); // Pick a random starting index
        int currentIndex = startIndex;

        do {
            Agent agent = agentList.get(currentIndex); // Get agent at the current index
            if (agent != caller) { // Skip the caller itself
                // Calculate the Euclidean distance between the agents
                double distance = Math.sqrt(Math.pow(caller.xc- agent.xc, 2)
                        + Math.pow(caller.yc - agent.yc, 2));
                if (distance <= radius) {
                    return agent; // Return the first suitable neighbor
                }
            }

            // Move to the next index (wrapping around if necessary)
            currentIndex = (currentIndex + 1) % agentList.size();

        } while (currentIndex != startIndex); // Repeat until we loop back to the start

        return null; // Return null if no suitable neighbor is found
    }

    public Iterator<Agent> iterator() {
        return agentList.iterator();
    }
}