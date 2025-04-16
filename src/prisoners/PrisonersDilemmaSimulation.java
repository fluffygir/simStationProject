package prisoners;

import mvc.AppPanel;
import simstation.*;
import java.util.*;

public class PrisonersDilemmaSimulation extends World {
    public void populate() {
        for (int i = 0; i < 10; i++) {
            addAgent(new Prisoner(this, new Cooperate()));
            addAgent(new Prisoner(this, new Cheat()));
            addAgent(new Prisoner(this, new RandomlyCooperate()));
            addAgent(new Prisoner(this, new Tit4Tat()));
        }

    }

    @Override
    public String getStatus() {
        Map<String, List<Integer>> fitnessByStrategy = new HashMap<>();

        for (Agent a : getAllAgents()) {
            Prisoner p = (Prisoner) a;
            String strat = p.getStrategyName();
            fitnessByStrategy.putIfAbsent(strat, new ArrayList<>());
            fitnessByStrategy.get(strat).add(p.getFitness());
        }

        List<String> stats = new ArrayList<>();
        for (String strategy : fitnessByStrategy.keySet()) {
            List<Integer> fitnessList = fitnessByStrategy.get(strategy);
            double avg = fitnessList.stream().mapToInt(Integer::intValue).average().orElse(0);
            stats.add(strategy + ": " + String.format("%.2f", avg));
        }
        return String.join("\n", stats) + "\n" +super.getStatus();

    }

    public List<Agent> getAllAgents() {
        List<Agent> list = new ArrayList<>();
        Iterator<Agent> it = this.iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list;
    }

    public static void main(String[] args) {
            AppPanel panel = new PrisonerPanel( new PrisonersDilemmaFactory());
            panel.display();
    }
}