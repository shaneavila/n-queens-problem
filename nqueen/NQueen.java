package nqueen;

import java.util.*;

public abstract class NQueen implements Comparator<NQueen>, Comparable<NQueen> {

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

    @Override
    public int compare(NQueen o1, NQueen o2) {
        for (int i = 0; i < state.length; i++) {
            if (o1.score >= o2.score && o1.getState()[i] < o2.getState()[i])
                return -1;
            else if (o1.score <= o2.score && o1.getState()[i] > o2.getState()[i])
                return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof NQueen))
            return false;
        NQueen nQueen = (NQueen) obj;
        return nQueen.score == score && Arrays.equals(nQueen.state,state);
    }

    abstract void genState();

    abstract int genScore();

}
