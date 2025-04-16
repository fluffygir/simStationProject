package Greed;

import simstation.*;
import mvc.*;
import javax.swing.*;
import java.awt.*;

public class GreedPanel extends WorldPanel {
    private JSlider greedSlider, growSlider, moveSlider;

    public GreedPanel(WorldFactory factory) {
    	super(factory);  // Call default constructor of SimulationPanel or AppPanel

        this.factory = factory;
        this.model = factory.makeModel();
        this.view = factory.makeView(model);

        setLayout(new BorderLayout());

        // === LEFT SIDEBAR ===
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(Color.PINK);

        // Top button bar (already added by SimulationPanel)
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.PINK);
        buttons.setLayout(new FlowLayout());

        // === SLIDER: Greed ===
        JLabel greedLabel = new JLabel("Greed:");
        greedSlider = new JSlider(0, 100, 25);
        greedSlider.setMajorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);

        JPanel greedPanel = new JPanel();
        greedPanel.setLayout(new BoxLayout(greedPanel, BoxLayout.Y_AXIS));
        greedPanel.setBackground(Color.PINK);
        greedPanel.add(greedLabel);
        greedPanel.add(greedSlider);

        // === SLIDER: Grow back rate ===
        JLabel growLabel = new JLabel("Grow back rate:");
        growSlider = new JSlider(0, 10, 1);
        growSlider.setMajorTickSpacing(1);
        growSlider.setPaintTicks(true);
        growSlider.setPaintLabels(true);

        JPanel growPanel = new JPanel();
        growPanel.setLayout(new BoxLayout(growPanel, BoxLayout.Y_AXIS));
        growPanel.setBackground(Color.PINK);
        growPanel.add(growLabel);
        growPanel.add(growSlider);

        // === SLIDER: Move Energy ===
        JLabel moveLabel = new JLabel("Move Energy:");
        moveSlider = new JSlider(0, 50, 10);
        moveSlider.setMajorTickSpacing(10);
        moveSlider.setPaintTicks(true);
        moveSlider.setPaintLabels(true);

        JPanel movePanel = new JPanel();
        movePanel.setLayout(new BoxLayout(movePanel, BoxLayout.Y_AXIS));
        movePanel.setBackground(Color.PINK);
        movePanel.add(moveLabel);
        movePanel.add(moveSlider);

        // Add sliders to sidebar
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(greedPanel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(growPanel);
        sidebar.add(Box.createRigidArea(new Dimension(0, 20)));
        sidebar.add(movePanel);

        // === FINAL LAYOUT ===
        add(sidebar, BorderLayout.WEST);
        add(view, BorderLayout.CENTER);  // simulation view

        // Resize the view to fit grid
        view.setPreferredSize(new Dimension(600, 600));
        revalidate();
    }

    @Override
    public void update() {
        super.update();
        Meadow.setUserGreediness(greedSlider.getValue());
        Meadow.moveEnergy = moveSlider.getValue();
        Patch.growBackRate = growSlider.getValue();
    }
}
