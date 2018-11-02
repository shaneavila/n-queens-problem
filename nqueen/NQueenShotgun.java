package nqueen;

import java.util.Random;

public class NQueenShotgun extends NQueen {

    public static final int SIZE = 8;
    public static final int goalScore = goalScore();
    private static final Random RANDOM = new Random(SIZE);

    public NQueenShotgun() {
        score = genScore();
    }

    public NQueenShotgun(int[] temp) {
        state = temp;
        score = genScore();
    }

    void genState() {
        state = new int[SIZE];
        for (int i = 0; i < state.length; i++)
            state[i] = RANDOM.nextInt(SIZE);
    }

    int genScore() {
        return super.genAttackScore();
    }

    private static int goalScore() {
        int goal = 0;
        return goal;
    }

    @Override
    public int compareTo(NQueen o) {
        //Score sorted in ascending order
        return (score < o.score) ? -1 : (score > o.score) ? 1 : 0;
    }

}
