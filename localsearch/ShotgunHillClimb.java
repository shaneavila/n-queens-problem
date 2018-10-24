package localsearch;

import nqueen.NQueenShotgun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShotgunHillClimb {

    private NQueenShotgun instance;
    private List<NQueenShotgun> nextStates;
    private static final int RESTART_LIMIT = 1000;

    public ShotgunHillClimb(NQueenShotgun instance) {
        this.instance = instance;
    }

    public NQueenShotgun search() {
        NQueenShotgun best = instance;
        NQueenShotgun current = instance;
        int limit = 0;
        do {
            NQueenShotgun neighbor = exploreStateSpace(current.getState()).get(0);
            if (neighbor.getScore() < current.getScore()) {
                current = neighbor;
                best = current;
            }
            else {
                current = new NQueenShotgun();
            }
            limit++;
        } while (!isGoal(current) && limit < RESTART_LIMIT);
        return best;
    }

    private List<NQueenShotgun> exploreStateSpace(int[] state) {
        nextStates = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state.length; j++) {
                if (state[i] == j)
                    continue;
                int temp[] = new int[state.length];
                System.arraycopy(state, 0, temp, 0, temp.length);
                temp[i] = j;
                nextStates.add(new NQueenShotgun(temp));
            }
        }
        Collections.sort(nextStates);
        return nextStates;
    }

    private boolean isGoal(NQueenShotgun current) {
        return current.getScore() <= 0;
    }

}
