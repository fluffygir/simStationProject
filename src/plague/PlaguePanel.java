package plague;

import simstation.WorldPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaguePanel extends WorldPanel {

    private JToggleButton fatalToggle;

    public PlaguePanel(PlagueFactory factory) {
        super(factory);

        // Create a vertical box to hold our sliders
        Box sliderBox = Box.createVerticalBox();

        // Initial % Infected
        JLabel initLabel = new JLabel("Initial % Infected:");
        JSlider initSlider = new JSlider(0, 100, PlagueSimulation.INITIAL_INFECTED);
        initSlider.setMajorTickSpacing(10);
        initSlider.setMinorTickSpacing(5);
        initSlider.setPaintTicks(true);
        initSlider.setPaintLabels(true);
        initSlider.addChangeListener(e -> {
            PlagueSimulation.INITIAL_INFECTED = initSlider.getValue();
            initLabel.setText("Initial % Infected: " + PlagueSimulation.INITIAL_INFECTED);
        });

        // Infection Probability (Virulence)
        JLabel virLabel = new JLabel("Infection Probability:");
        JSlider virSlider = new JSlider(0, 100, PlagueSimulation.VIRULENCE);
        virSlider.setMajorTickSpacing(10);
        virSlider.setMinorTickSpacing(5);
        virSlider.setPaintTicks(true);
        virSlider.setPaintLabels(true);
        virSlider.addChangeListener(e -> {
            PlagueSimulation.VIRULENCE = virSlider.getValue();
            virLabel.setText("Infection Probability: " + PlagueSimulation.VIRULENCE);
        });

        // Initial Population Size
        JLabel popLabel = new JLabel("Initial Population Size:");
        JSlider popSlider = new JSlider(0, 200, PlagueSimulation.POP_SIZE);
        popSlider.setMajorTickSpacing(20);
        popSlider.setMinorTickSpacing(10);
        popSlider.setPaintTicks(true);
        popSlider.setPaintLabels(true);
        popSlider.addChangeListener(e -> {
            PlagueSimulation.POP_SIZE = popSlider.getValue();
            popLabel.setText("Initial Population Size: " + PlagueSimulation.POP_SIZE);
        });

        // Fatality/Recovery Time
        JLabel recLabel = new JLabel("Fatality/Recovery Time:");
        JSlider recSlider = new JSlider(0, 500, PlagueSimulation.RECOVERY_TIME);
        recSlider.setMajorTickSpacing(100);
        recSlider.setMinorTickSpacing(50);
        recSlider.setPaintTicks(true);
        recSlider.setPaintLabels(true);
        recSlider.addChangeListener(e -> {
            PlagueSimulation.RECOVERY_TIME = recSlider.getValue();
            recLabel.setText("Fatality/Recovery Time: " + PlagueSimulation.RECOVERY_TIME);
        });

        // Fatal toggle button
        fatalToggle = new JToggleButton("Not Fatal");
        fatalToggle.setSelected(false); // Default is fatal
        fatalToggle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for toggling fatality in the simulation
                // Will be applied to newly created agents when simulation starts
                if (model instanceof PlagueSimulation) {
                    ((PlagueSimulation) model).setFatal(!fatalToggle.isSelected());
                }
            }
        });

        // Add components to the slider box
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(initLabel);
        sliderBox.add(initSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(virLabel);
        sliderBox.add(virSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(popLabel);
        sliderBox.add(popSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(recLabel);
        sliderBox.add(recSlider);
        sliderBox.add(Box.createVerticalStrut(10));

        // Add fatal toggle button at the bottom
        JPanel togglePanel = new JPanel();
        togglePanel.add(fatalToggle);
        sliderBox.add(togglePanel);
        sliderBox.add(Box.createVerticalStrut(10));

        // Place sliders under the existing buttons
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(threadPanel, BorderLayout.NORTH);
        controlPanel.add(sliderBox, BorderLayout.CENTER);
    }
}