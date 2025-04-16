package Greed;

import simstation.*;
import mvc.*;
import java.awt.*;

public class GreedView extends WorldView {
    public GreedView(Model model) {
        super(model);
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Meadow meadow = (Meadow) model;
        int patchSize = Meadow.patchSize;

        // Draw patches
        for (int i = 0; i < Meadow.dim; i++) {
            for (int j = 0; j < Meadow.dim; j++) {
                Patch patch = meadow.getPatch(i * patchSize, j * patchSize);
                int green = (int)(255.0 * patch.getEnergy() / Patch.MAX_ENERGY);
                gc.setColor(new Color(0, green, 0));
                gc.fillRect(i * patchSize, j * patchSize, patchSize, patchSize);
                gc.setColor(Color.BLACK);
                gc.drawRect(i * patchSize, j * patchSize, patchSize, patchSize);
            }
        }

        // Draw cows
        for (Cow cow : meadow.getCows()) {
            gc.setColor(cow.isAlive() ? Color.RED : Color.WHITE);
            gc.fillOval(cow.xc, cow.yc, 5, 5);
        }
    }
}
