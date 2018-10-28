package main;

import localsearch.GeneticAlg;
import localsearch.ShotgunHillClimb;
import nqueen.NQueenGenetic;
import nqueen.NQueenShotgun;

import java.util.*;

public class Main {

    private static int SOLUTION_CAP = 1000;

    public static void main(String[] args) {
        NQueenShotgun shotgunInit = new NQueenShotgun();
        ShotgunHillClimb hillClimb = new ShotgunHillClimb(shotgunInit);
        NQueenShotgun shotgunSol = hillClimb.search();
        System.out.println(shotgunSol);

        List<NQueenGenetic> solutionSet = new ArrayList<>();
        int count = 0;
        while (solutionSet.size() < SOLUTION_CAP && count < SOLUTION_CAP * 5) {
            GeneticAlg genAlg = new GeneticAlg();
            NQueenGenetic geneticSol = genAlg.search();
            if (!solutionSet.contains(geneticSol) && geneticSol.getScore() == NQueenGenetic.goalScore())
                solutionSet.add(geneticSol);
            count++;
        }
        Collections.sort(solutionSet, new NQueenGenetic());
        for (NQueenGenetic n : solutionSet)
            System.out.println(n);
        System.out.println(solutionSet.size());

    }
}
