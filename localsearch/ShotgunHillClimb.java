package localsearch;

import main.NQueen;

public class ShotgunHillClimb {

    private NQueen solution;
    private static final int RESTART_LIMIT;

    static
    {
        RESTART_LIMIT = 1000;
    }

    public ShotgunHillClimb(NQueen solution) {
        this.solution = solution;
    }

    public NQueen search() {
        NQueen best = solution;
        NQueen current = solution;
        int limit = 0;
        do {
            NQueen nextState = current.exploreStateSpace().get(0);
            if (nextState.getScore() < current.getScore()) {
                current = nextState;
                best = current;
            }
            else {
                current = new NQueen();
            }
            limit++;
        } while (!isGoal(current) && limit < RESTART_LIMIT);
        return best;
    }

    private boolean isGoal(NQueen current) {
        return current.getScore() <= 0;
    }

}
