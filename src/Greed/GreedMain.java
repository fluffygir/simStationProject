package Greed;

import simstation.*;
import mvc.*;

public class GreedMain {
    public static void main(String[] args) {
        WorldFactory factory = new GreedFactory();
        AppPanel panel = new GreedPanel(factory);
        panel.display();
    }
}
