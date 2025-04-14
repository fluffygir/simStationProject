package prisoners;

import mvc.*;

public class PrisonersDilemmaMain {
    public static void main(String[] args) {
        AppFactory factory = new PrisonersDilemmaFactory();
        AppPanel panel = new AppPanel(factory);
        panel.display(); 
    }
}
