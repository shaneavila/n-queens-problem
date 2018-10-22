package main;

import java.util.*;

public class NQueen implements Comparable{

    private int[] state;
    private int   score;
    private List<NQueen> nextStates;

    private static final int SIZE;
    private static final Random RANDOM;

    static
    {
        SIZE = 20;
        RANDOM = new Random(SIZE);
    }

    public NQueen() {
        genState();
        score = genScore();
    }

    public NQueen(int[] temp) {
        state = temp;
        score = genScore();
    }

    public void genState() {
        state = new int[SIZE];
        for (int i = 0; i < state.length; i++)
            state[i] = RANDOM.nextInt(SIZE);
    }

    private int genScore() {
       score = 0;
       for (int i = 0; i < state.length; i++) {
           for (int j = i+1; j < state.length; j++) {
               if (state[i] == state[j])
                   score++;
               // |x1-x2| == |y1-y2|
               if (Math.abs(state[i] - state[j]) == Math.abs(i - j))
                   score++;
           }
       }
       return score;
    }

    public List<NQueen> exploreStateSpace() {
        nextStates = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                if (state[i] == j)
                    continue;
                int temp[] = new int[state.length];
                System.arraycopy(state, 0, temp, 0, temp.length);
                temp[i] = j;
                nextStates.add(new NQueen(temp));
            }
        }
        Collections.sort(nextStates);
        return nextStates;
    }

    public int getScore() { return score; }

    @Override
    public String toString() {
        return "\n"+Arrays.toString(state) + " Score: " + score;
    }

    @Override
    public int compareTo(Object o) {
        return (score < ((NQueen)o).score) ? -1 : (score > ((NQueen)o).score) ? 1 : 0;
    }

}
