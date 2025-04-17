package greed;

import mvc.AppPanel;
import simstation.*;
import java.util.*;

import static greed.Patch.patchSize;

public class Meadow extends World {
    public static int waitPenalty = 5;
    public static int moveEnergy = 10;
    public static int numCows = 50;
    public static int dim = 50;


    public static int growBackRate;

    private Patch[][] patches;
    private List<Cow> cows = new ArrayList<>();

    public Meadow() {
        patches = new Patch[dim][dim];
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                patches[i][j] = new Patch(10, 20);
            }
        }
    }

    @Override
    public void populate() {
        for (int i = 0; i < numCows; i++) {
            Cow c = new Cow(this);
            addAgent(c);
            cows.add(c);
        }
    }

    public Patch getPatch(int xc, int yc) {
        int i = xc / patchSize;
        int j = yc / patchSize;
        if (i < 0 || j < 0 || i >= dim || j >= dim) return null;
        return patches[i][j];
    }

    public void growPatches() {
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                patches[i][j].update();
            }
        }
    }

    public List<Cow> getCows() {
        return cows;
    }

    public static int getWaitPenalty() {
        return waitPenalty;
    }

    public static int getMoveEnergy() {
        return moveEnergy;
    }

    public static int getGrowBackRate() {
        return growBackRate;
    }

    public static void main(String[] args) {
        AppPanel panel = new GreedPanel(new GreedFactory());
        panel.display();
    }

}

