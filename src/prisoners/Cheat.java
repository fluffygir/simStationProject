package prisoners;

public class Cheat implements Strategy {
    public boolean cooperate() { return false; }
    public void setCheated(boolean cheated) {}
}
