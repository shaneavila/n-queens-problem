package nqueen;

public class NQueenGenetic extends NQueen {

    public NQueenGenetic() {
        score = genScore();
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
    public int compareTo(Object o) {
        //TODO this is the opposite of shotgun as a test
        return (score < ((NQueen)o).score) ? 1 : (score > ((NQueen)o).score) ? -1 : 0;
    }
}
