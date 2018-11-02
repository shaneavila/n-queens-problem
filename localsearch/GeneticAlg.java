package localsearch;

import nqueen.NQueenGenetic;

import java.util.*;

import static java.lang.Integer.min;

public class GeneticAlg {

    private static final int MUTATION_CHANCE = 200;        // 1 in N probability of occurring
    private static final int POPULATION_SIZE = 1000;
    private static final Random RANDOM = new Random(POPULATION_SIZE);
    private List<NQueenGenetic> population;

    public GeneticAlg() {
        population = initialPopulation();
    }

    private List<NQueenGenetic> initialPopulation() {
        population = new ArrayList<>();
        for (int i = 0; i < POPULATION_SIZE; i++)
            population.add(new NQueenGenetic());
        Collections.sort(population);
        return population;
    }

    public NQueenGenetic search() {
        int count = 0;
        List<NQueenGenetic> newPopulation;
        while(!isGoal() && count < 25000) {
            newPopulation = new ArrayList<>();
            for (int i = 0; i < POPULATION_SIZE; i++) {
                NQueenGenetic x = population.get(min(RANDOM.nextInt(POPULATION_SIZE), RANDOM.nextInt(POPULATION_SIZE)));
                NQueenGenetic y = population.get(min(RANDOM.nextInt(POPULATION_SIZE), RANDOM.nextInt(POPULATION_SIZE)));
                NQueenGenetic child = new NQueenGenetic(reproduce(x, y));
                boolean chance = RANDOM.nextInt(MUTATION_CHANCE) == 0;
                if (chance)
                    child = new NQueenGenetic(mutate(child));
                newPopulation.add(child);
                count++;
                if (child.getScore() == NQueenGenetic.goalScore)
                    break;
            }
            population.addAll(newPopulation);
            Collections.sort(population);
        }
        return population.get(0);
    }

    private boolean isGoal() {
        return population.get(0).getScore() == NQueenGenetic.goalScore;
    }

    private int[] reproduce(NQueenGenetic x, NQueenGenetic y) {
        int[] child = new int[x.getState().length];
        int randPosition = RANDOM.nextInt(child.length);
        System.arraycopy(x.getState(),0, child, 0, randPosition);
        System.arraycopy(y.getState(),randPosition, child, randPosition ,child.length-randPosition);
        return child;
    }

    private int[] mutate(NQueenGenetic child) {
        int[] mutation = child.getState();
        mutation[RANDOM.nextInt(mutation.length)] = RANDOM.nextInt(mutation.length);
        return mutation;
    }
}
