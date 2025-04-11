package plague;

import simstation.WorldPanel;
import javax.swing.*;
import java.awt.*;

public class PlaguePanel extends WorldPanel {

    public PlaguePanel(PlagueFactory factory) {
        super(factory);


        controlPanel.setBackground(Color.PINK);


        Box centerBox = Box.createVerticalBox();
        centerBox.setOpaque(false);

        // Initial % Infected
        JLabel initLabel = new JLabel("Initial % Infected: " + PlagueSimulation.INITIAL_INFECTED + "%");
        initLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider initSlider = new JSlider(0, 100, PlagueSimulation.INITIAL_INFECTED);
        initSlider.setMajorTickSpacing(10);
        initSlider.setMinorTickSpacing(1);
        initSlider.setPaintTicks(true);
        initSlider.setPaintLabels(true);
        initSlider.addChangeListener(e -> {
            PlagueSimulation.INITIAL_INFECTED = initSlider.getValue();
            initLabel.setText("Initial % Infected: " + PlagueSimulation.INITIAL_INFECTED + "%");
        });
        initSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Infection Probability (Virulence)
        JLabel virLabel = new JLabel("Infection Probability: " + PlagueSimulation.VIRULENCE + "%");
        virLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider virSlider = new JSlider(0, 100, PlagueSimulation.VIRULENCE);
        virSlider.setMajorTickSpacing(10);
        virSlider.setMinorTickSpacing(1);
        virSlider.setPaintTicks(true);
        virSlider.setPaintLabels(true);
        virSlider.addChangeListener(e -> {
            PlagueSimulation.VIRULENCE = virSlider.getValue();
            virLabel.setText("Infection Probability: " + PlagueSimulation.VIRULENCE + "%");
        });
        virSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Initial Population Size
        JLabel popLabel = new JLabel("Initial Population Size: " + PlagueSimulation.POP_SIZE);
        popLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider popSlider = new JSlider(0, 200, PlagueSimulation.POP_SIZE);
        popSlider.setMajorTickSpacing(20);
        popSlider.setMinorTickSpacing(5);
        popSlider.setPaintTicks(true);
        popSlider.setPaintLabels(true);
        popSlider.addChangeListener(e -> {
            PlagueSimulation.POP_SIZE = popSlider.getValue();
            popLabel.setText("Initial Population Size: " + PlagueSimulation.POP_SIZE);
        });
        popSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Fatality/Recovery Time
        JLabel recLabel = new JLabel("Fatality/Recovery Time: " + PlagueSimulation.RECOVERY_TIME);
        recLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JSlider recSlider = new JSlider(0, 500, PlagueSimulation.RECOVERY_TIME);
        recSlider.setMajorTickSpacing(50);
        recSlider.setMinorTickSpacing(10);
        recSlider.setPaintTicks(true);
        recSlider.setPaintLabels(true);
        recSlider.addChangeListener(e -> {
            PlagueSimulation.RECOVERY_TIME = recSlider.getValue();
            recLabel.setText("Fatality/Recovery Time: " + PlagueSimulation.RECOVERY_TIME);
        });
        recSlider.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Not Fatal toggle button
        JButton fatalToggle = new JButton(PlagueSimulation.IS_FATAL ? "Fatal" : "Not Fatal");
        fatalToggle.setAlignmentX(Component.CENTER_ALIGNMENT);
        fatalToggle.addActionListener(e -> {
            PlagueSimulation.IS_FATAL = !PlagueSimulation.IS_FATAL;
            fatalToggle.setText(PlagueSimulation.IS_FATAL ? "Fatal" : "Not Fatal");
        });


        centerBox.add(Box.createVerticalStrut(10));
        centerBox.add(initLabel);
        centerBox.add(initSlider);
        centerBox.add(Box.createVerticalStrut(10));
        centerBox.add(virLabel);
        centerBox.add(virSlider);
        centerBox.add(Box.createVerticalStrut(10));
        centerBox.add(popLabel);
        centerBox.add(popSlider);
        centerBox.add(Box.createVerticalStrut(10));
        centerBox.add(recLabel);
        centerBox.add(recSlider);
        centerBox.add(Box.createVerticalStrut(15));
        centerBox.add(fatalToggle);
        centerBox.add(Box.createVerticalGlue());

        controlPanel.add(centerBox, BorderLayout.CENTER);
    }
}
