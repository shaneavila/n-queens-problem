package nqueen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class NQueenGenetic extends NQueen implements Comparator<NQueenGenetic> {

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
        return goalScore - super.genAttackScore();
    }

    public static int goalScore() {
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

    @Override
    public int compare(NQueenGenetic o1, NQueenGenetic o2) {
        for (int i = 0; i < SIZE; i++) {
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
}
