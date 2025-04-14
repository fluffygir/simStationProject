package prisoners;

public class Tit4Tat implements Strategy {
    private boolean partnerCheated = false;

    public boolean cooperate() {
        return !partnerCheated;
    }

    public void setCheated(boolean cheated) {
        partnerCheated = cheated;
    }
}
