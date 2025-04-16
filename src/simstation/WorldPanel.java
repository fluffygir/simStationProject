package simstation;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class WorldPanel extends AppPanel {

    public JPanel threadPanel = new JPanel();

    public WorldPanel(WorldFactory factory) {
        super(factory);

        threadPanel.setLayout(new GridLayout(1, 5));
        threadPanel.setOpaque(false);

        JPanel p = new JPanel();
        p.setOpaque(false);
        JButton button = new JButton("Start");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Pause");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Resume");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stop");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        p = new JPanel();
        p.setOpaque(false);
        button = new JButton("Stats");
        button.addActionListener(this);
        p.add(button);
        threadPanel.add(p);

        controlPanel.setLayout(new BorderLayout());

        p = new JPanel();
        p.setOpaque(false);
        p.add(threadPanel);

        controlPanel.add(p,  BorderLayout.NORTH);
    }

    @Override
    public void setModel(Model m) {
        super.setModel(m);
        World w = (World)m;
        Iterator<Agent> it = w.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
        w.observer.myThread = new Thread(w.observer);
        w.observer.myThread.start(); //have to start the observer agent on file load
    }

    @Override //overrides save commands to require the simulation be stopped
    public void actionPerformed(ActionEvent ae) {
        try {
            String cmmd = ae.getActionCommand();
            World w = (World)model;
            if (cmmd.equals("Save")) {
                if(!w.observer.isStopped()){
                    throw new RuntimeException("Must stop simulation before saving");
                }
                Utilities.save(model, false);
            } else if (cmmd.equals("SaveAs")) {
                if(!w.observer.isStopped()){
                    throw new RuntimeException("Must stop simulation before saving");
                }
                Utilities.save(model, true);
            } else {
                super.actionPerformed(ae);
            }
        } catch (Exception e) {
            handleException(e);
        }
    }

}