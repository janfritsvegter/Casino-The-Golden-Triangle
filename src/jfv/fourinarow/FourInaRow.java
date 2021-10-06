package jfv.fourinarow;

import java.util.Random;
import java.util.Scanner;

public class FourInaRow extends jfv.Games{
    private Scanner inputScanner;
    private Random random;
    private String gameName;

    public FourInaRow (Scanner inputScanner, Random random) {
        this.inputScanner = inputScanner;
        this.random = random;
        this.gameName = "Four in a row";
        //      this.deck = new Deck();
    }

    @Override
    public String getGameName() {
        return this.gameName;
    }


}


