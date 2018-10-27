package nqueen;

import java.util.Random;

public class NQueenShotgun extends NQueen {

    private static final int SIZE = 8;
    private static final Random RANDOM = new Random(SIZE);

    public NQueenShotgun() {
        score = genScore();
    }

    public NQueenShotgun(int[] temp) {
        state = temp;
        score = genAttackScore();
    }

    void genState() {
        state = new int[SIZE];
        for (int i = 0; i < state.length; i++)
            state[i] = RANDOM.nextInt(SIZE);
    }

    int genScore() {
        return genAttackScore();
    }

    public int genAttackScore() {
        return super.genAttackScore();
    }

    @Override
    public int compareTo(NQueen o) {
        //Score sorted in ascending order
        return (score < o.score) ? -1 : (score > o.score) ? 1 : 0;
    }

}
