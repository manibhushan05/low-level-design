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
        return (int) (Math.random() * (MAX_VALUE - MIN_VALUE + 1) + MIN_VALUE);
    }
}
