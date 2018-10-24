package nqueen;

import java.util.*;

abstract class NQueen implements Comparable<NQueen>{

    int[] state;
    int   score;

    public NQueen() {
        genState();
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
