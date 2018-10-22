package main;

import localsearch.ShotgunHillClimb;

public class Main {
    public static void main(String[] args) {
        NQueen initial = new NQueen();
        ShotgunHillClimb hillClimb = new ShotgunHillClimb(initial);
        initial = hillClimb.search();
        System.out.println(initial);
    }
}
