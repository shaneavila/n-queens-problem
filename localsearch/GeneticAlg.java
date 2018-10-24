package localsearch;

import nqueen.NQueenGenetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GeneticAlg {

    //private NQueenGenetic instance;
    private List<NQueenGenetic> newPopulation;
    private static final int INIT_POPULATION_SIZE = 1000;
    private static final int MUTATION_CHANCE = 1000;
    private static final Random RANDOM = new Random(INIT_POPULATION_SIZE);

    public GeneticAlg(NQueenGenetic instance) {
        //this.instance = instance;
    }

    public NQueenGenetic search() {

        while(true) {
            newPopulation = new ArrayList<>();
            for (int i = 0; i < INIT_POPULATION_SIZE; i++) {
                NQueenGenetic x = new NQueenGenetic();
                NQueenGenetic y = new NQueenGenetic();
                NQueenGenetic child = new NQueenGenetic(reproduce(x,y));
                boolean chance = RANDOM.nextInt(MUTATION_CHANCE)==0;
                if (chance)
                  child = new NQueenGenetic(mutate(child));
                newPopulation.add(child);
            }
            return null;
        }
    }

    private int[] reproduce(NQueenGenetic x, NQueenGenetic y) {
        System.out.println();
        int t = RANDOM.nextInt(x.getState().length);
        System.out.println(x);
        System.out.println(y);
        System.out.println(t);
        System.arraycopy(y.getState(),t, x.getState(), t ,x.getState().length-t);
        System.out.println(x);
        System.out.println(y);
        return x.getState();
    }

    private int[] mutate(NQueenGenetic child) {
        System.out.println();
        System.out.println("MUTATION");
        int length = child.getState().length;
        System.out.println(child);
        child.getState()[RANDOM.nextInt(length)] = RANDOM.nextInt(length);
        System.out.println(child);
        return child.getState();
    }
}
