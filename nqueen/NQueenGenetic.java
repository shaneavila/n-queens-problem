package nqueen;

import java.util.Arrays;
import java.util.Random;

public class NQueenGenetic extends NQueen {

    private static final int SIZE = 8;
    private static final int goalScore = goalScore();
    private static final Random RANDOM = new Random(SIZE);

    public NQueenGenetic() {
        score = genScore();
    }

    public NQueenGenetic(int[] temp) {
        state = temp;
        score = genScore();
    }

    void genState() {
        state = new int[SIZE];
        for (int i = 0; i < state.length; i++)
            state[i] = RANDOM.nextInt(SIZE);
    }

    int genScore() {
        return genNonAttackScore();
    }

    private int genNonAttackScore() {
        return goalScore - super.genAttackScore();
    }

    private static int goalScore() {
        int score = 0;
        for (int i = 0; i < SIZE; i++)
            score += i;
        return score;
    }

    @Override
    public int compareTo(NQueen o) {
        //Score sorted in descending order
        return (score < o.score) ? 1 : (score > o.score) ? -1 : 0;
    }
}
