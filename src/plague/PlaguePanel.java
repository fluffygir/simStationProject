// PlaguePanel.java
package plague;

import simstation.WorldPanel;
import javax.swing.*;
import java.awt.*;

public class PlaguePanel extends WorldPanel {

    public PlaguePanel(PlagueFactory factory) {
        super(factory);

        // Create a vertical box to hold our sliders
        Box sliderBox = Box.createVerticalBox();

        // Initial % Infected
        JLabel initLabel = new JLabel("Initial % Infected: " + PlagueSimulation.INITIAL_INFECTED + "%");
        JSlider initSlider = new JSlider(0, 100, PlagueSimulation.INITIAL_INFECTED);
        initSlider.setMajorTickSpacing(10);
        initSlider.setMinorTickSpacing(5);
        initSlider.setPaintTicks(true);
        initSlider.setPaintLabels(true);
        initSlider.addChangeListener(e -> {
            PlagueSimulation.INITIAL_INFECTED = initSlider.getValue();
            initLabel.setText("Initial % Infected: " + PlagueSimulation.INITIAL_INFECTED + "%");
        });

        // Population Size
        JLabel popLabel = new JLabel("Population Size: " + PlagueSimulation.POP_SIZE);
        JSlider popSlider = new JSlider(10, 100, PlagueSimulation.POP_SIZE);
        popSlider.setMajorTickSpacing(30);
        popSlider.setMinorTickSpacing(5);
        popSlider.setPaintTicks(true);
        popSlider.setPaintLabels(true);
        popSlider.addChangeListener(e -> {
            PlagueSimulation.POP_SIZE = popSlider.getValue();
            popLabel.setText("Population Size: " + PlagueSimulation.POP_SIZE);
        });

        // Virulence
        JLabel virLabel = new JLabel("Virulence: " + PlagueSimulation.VIRULENCE + "%");
        JSlider virSlider = new JSlider(0, 100, PlagueSimulation.VIRULENCE);
        virSlider.setMajorTickSpacing(20);
        virSlider.setMinorTickSpacing(5);
        virSlider.setPaintTicks(true);
        virSlider.setPaintLabels(true);
        virSlider.addChangeListener(e -> {
            PlagueSimulation.VIRULENCE = virSlider.getValue();
            virLabel.setText("Virulence: " + PlagueSimulation.VIRULENCE + "%");
        });

        JLabel recLabel = new JLabel("Recovery Time: " + PlagueSimulation.RECOVERY_TIME);
        JSlider recSlider = new JSlider(0, 500, PlagueSimulation.RECOVERY_TIME);
        recSlider.setMajorTickSpacing(100);
        recSlider.setMinorTickSpacing(10);
        recSlider.setPaintTicks(true);
        recSlider.setPaintLabels(true);
        recSlider.addChangeListener(e -> {
            PlagueSimulation.RECOVERY_TIME = recSlider.getValue();
            recLabel.setText("Recovery Time: " + PlagueSimulation.RECOVERY_TIME);
        });

        // Add some spacing and then all controls
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(initLabel);
        sliderBox.add(initSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(popLabel);
        sliderBox.add(popSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(virLabel);
        sliderBox.add(virSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(recLabel);
        sliderBox.add(recSlider);
        sliderBox.add(Box.createVerticalStrut(10));

        // Optional: match your screenshot’s background color
        sliderBox.setBackground(Color.PINK);

        // Place sliders under the existing buttons
        controlPanel.add(sliderBox, BorderLayout.CENTER);
    }
}
