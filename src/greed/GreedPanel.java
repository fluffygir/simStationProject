
package greed;
import simstation.WorldPanel;
import javax.swing.*;
import java.awt.*;

public class GreedPanel extends WorldPanel {
    public GreedPanel(GreedFactory factory) {
        super(factory);

        Box sliderBox = Box.createVerticalBox();


        JLabel greedLabel = new JLabel("Greed:");
        JSlider greedSlider = new JSlider(0, 100, 25);
        greedSlider.setMajorTickSpacing(10);
        greedSlider.setPaintTicks(true);
        greedSlider.setPaintLabels(true);


        JLabel growLabel = new JLabel("Grow back rate:");
        JSlider growSlider = new JSlider(0, 10,1);
        growSlider.setMajorTickSpacing(1);
        growSlider.setPaintTicks(true);
        growSlider.setPaintLabels(true);


        JLabel moveLabel = new JLabel("Move Energy:");
        JSlider moveSlider = new JSlider(0, 50, 10);
        moveSlider.setMajorTickSpacing(10);
        moveSlider.setPaintTicks(true);
        moveSlider.setPaintLabels(true);

        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(greedLabel);
        sliderBox.add(greedSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(growLabel);
        sliderBox.add(growSlider);
        sliderBox.add(Box.createVerticalStrut(10));
        sliderBox.add(moveLabel);
        sliderBox.add(moveSlider);
        sliderBox.add(Box.createVerticalStrut(10));

        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(threadPanel, BorderLayout.NORTH);
        controlPanel.add(sliderBox, BorderLayout.CENTER);
    }
}

