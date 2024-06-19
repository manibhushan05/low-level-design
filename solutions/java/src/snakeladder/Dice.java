package snakeladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE + 1);
    }
}
