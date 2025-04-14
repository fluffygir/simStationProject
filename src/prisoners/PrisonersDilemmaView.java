package prisoners;

import mvc.*;
import java.awt.*;
import javax.swing.*;

public class PrisonersDilemmaView extends View {
    private JTextArea statsArea;

    public PrisonersDilemmaView(Model model) {
        super(model);
        setLayout(new BorderLayout());

        statsArea = new JTextArea();
        statsArea.setEditable(false);
        add(new JScrollPane(statsArea), BorderLayout.CENTER);
    }

    @Override
    public void update() {
        PrisonersDilemmaSimulation sim = (PrisonersDilemmaSimulation) model;
        StringBuilder sb = new StringBuilder();
        sb.append("Average Fitness by Strategy:\n\n");

        for (String stat : sim.getStats()) {
            sb.append(stat).append("\n");
        }

        statsArea.setText(sb.toString());
    }
}
