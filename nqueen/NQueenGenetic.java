package nqueen;

import java.util.Random;

public class NQueenGenetic extends NQueen {

    private static final int SIZE = 8;
    private static final Random RANDOM = new Random(SIZE);

    public NQueenGenetic() {
        score = genScore();
    }

    public NQueenGenetic(int[] temp) {
        state = temp;
        score = genNonAttackScore();
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
        score = 0;
        for (int i = 0; i < state.length; i++) {
            for (int j = i+1; j < state.length; j++) {
                if (state[i] != state[j])
                    score++;
                if (Math.abs(state[i] - state[j]) == Math.abs(i - j))
                    score++;
            }
        }
        return score;
    }

    @Override
    public int compareTo(NQueen o) {
        //TODO this is the opposite of shotgun as a test
        return (score < o.score) ? 1 : (score > o.score) ? -1 : 0;
    }
}
