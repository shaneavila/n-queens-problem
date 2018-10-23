package nqueen;

public class NQueenShotgun extends NQueen {

    public NQueenShotgun() {
        score = genScore();
    }

    public NQueenShotgun(int[] temp) {
        state = temp;
        score = genAttackScore();
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
    public int compareTo(Object o) {
        return (score < ((NQueen)o).score) ? -1 : (score > ((NQueen)o).score) ? 1 : 0;
    }

}
