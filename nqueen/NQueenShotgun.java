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

    private int genAttackScore() {
        score = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = i+1; j < state.length; j++) {
                if (state[i] == state[j])
                    score++;
                if (Math.abs(state[i] - state[j]) == Math.abs(i - j))
                    score++;
            }
        }
        return score;
    }

    @Override
    public int compareTo(NQueen o) {
        return (score < o.score) ? -1 : (score > o.score) ? 1 : 0;
    }

}
