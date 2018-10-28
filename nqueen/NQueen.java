package nqueen;

import java.util.*;

abstract class NQueen implements Comparable<NQueen>{

    int[] state;
    int   score;

    public NQueen() {
        genState();
    }

    public int genAttackScore() {
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

    public int[] getState() { return state; }

    public int getScore() { return score; }

    @Override
    public String toString() {
        return Arrays.toString(state) + " Score: " + score;
    }

    abstract void genState();

    abstract int genScore();

}
