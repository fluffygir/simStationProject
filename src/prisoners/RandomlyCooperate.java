package prisoners;

import java.util.Random;

public class RandomlyCooperate implements Strategy {
    private final Random random = new Random();
    public boolean cooperate() { return random.nextBoolean(); }
    public void setCheated(boolean cheated) {}
}
