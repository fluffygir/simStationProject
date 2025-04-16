package prisoners;

import java.io.Serializable;

public interface Strategy extends Serializable {
    boolean cooperate();
    void setCheated(boolean cheated);
}
