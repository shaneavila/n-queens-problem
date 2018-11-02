package main;

import localsearch.GeneticAlg;
import localsearch.ShotgunHillClimb;
import nqueen.NQueenGenetic;
import nqueen.NQueenShotgun;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ShotgunHillClimb hillClimb = new ShotgunHillClimb();
        NQueenShotgun shotgunSol = hillClimb.search();
        System.out.println("Shotgun Hill Climbing: " + shotgunSol);

        GeneticAlg g = new GeneticAlg();
        NQueenGenetic gSol = g.search();
        System.out.println("\tGenetic Algorithm: "+gSol+"\n");

//        generateShotgunSolutions();
//        generateGeneticSolutions();
    }

    private static void generateShotgunSolutions() {
        int count = 0;
        int solutionCap = 1000;
        List<NQueenShotgun> solutionSet = new ArrayList<>();
        while (solutionSet.size() < solutionCap && count < solutionCap) {
            ShotgunHillClimb hillClimb = new ShotgunHillClimb();
            NQueenShotgun shotgunSol = hillClimb.search();
            if (!solutionSet.contains(shotgunSol) && shotgunSol.getScore() == NQueenShotgun.goalScore)
                solutionSet.add(shotgunSol);
            count++;
        }
        solutionSet.sort(new NQueenShotgun());
        System.out.print("Shotgun Hill Climbing Solutions for ");
        System.out.println(NQueenShotgun.SIZE+"x"+NQueenShotgun.SIZE);
        for (NQueenShotgun n : solutionSet)
            System.out.println(n);
        System.out.println("Solutions found: " + solutionSet.size()+"\n");
    }

    private static void generateGeneticSolutions() {
        int count = 0;
        int solutionCap = 1000;
        List<NQueenGenetic> solutionSet = new ArrayList<>();
        while (solutionSet.size() < solutionCap && count < solutionCap) {
            GeneticAlg genAlg = new GeneticAlg();
            NQueenGenetic geneticSol = genAlg.search();
            if (!solutionSet.contains(geneticSol) && geneticSol.getScore() == NQueenGenetic.goalScore)
                solutionSet.add(geneticSol);
            count++;
        }
        solutionSet.sort(new NQueenGenetic());
        System.out.print("Genetic Algorithm Solutions for ");
        System.out.println(NQueenGenetic.SIZE+"x"+NQueenGenetic.SIZE);
        for (NQueenGenetic n : solutionSet)
            System.out.println(n);
        System.out.println("Solutions found: " + solutionSet.size()+"\n");
    }
}
