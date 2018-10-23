package nqueen;

import java.util.*;

abstract class NQueen implements Comparable{

    int[] state;
    int   score;

    private static final int SIZE;
    private static final Random RANDOM;

    static
    {
        SIZE = 8;
        RANDOM = new Random(SIZE);
    }

    public NQueen() {
        genState();
    }

    public void genState() {
        state = new int[SIZE];
        for (int i = 0; i < state.length; i++)
            state[i] = RANDOM.nextInt(SIZE);
    }

    public int[] getState() { return state; }

    public int getScore() { return score; }

    @Override
    public String toString() {
        return "\n"+Arrays.toString(state) + " Score: " + score;
    }

    abstract int genScore();
}
