package main;

import localsearch.GeneticAlg;
import localsearch.ShotgunHillClimb;
import nqueen.NQueenGenetic;
import nqueen.NQueenShotgun;

public class Main {
    public static void main(String[] args) {
        NQueenShotgun shotgunInit = new NQueenShotgun();
        ShotgunHillClimb hillClimb = new ShotgunHillClimb(shotgunInit);
        NQueenShotgun shotgunSol = hillClimb.search();
        System.out.println(shotgunSol);

        NQueenGenetic geneticInit = new NQueenGenetic();
        GeneticAlg genAlg = new GeneticAlg();
        NQueenGenetic geneticSol = genAlg.search();
        //System.out.println(geneticSol);
    }
}
