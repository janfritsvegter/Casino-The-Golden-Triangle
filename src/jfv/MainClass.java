package jfv;

import jfv.fourinarow.FourInaRow;
import jfv.oops.Oops;
import jfv.tictactoe.TicTacToe;

import java.util.*;


public class MainClass {
    public static void main(String[] args) {
        Games game;
        List<Player> players = new ArrayList<>();
        Queue<Player> queuePlayers = new LinkedList<>();
        int timesPlayed;



/*

        System.out.println(players.size());
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
*/

        for (int i = 0; i < players.size() ; i++) {
            queuePlayers.add(players.get(i));
        }
        boolean stopPlaying = false;
        while (!stopPlaying) {
            // TODO at the moment you play a second game the list of players is not empty so new players will be added
            game = createGame();

            System.out.println("U heeft gekozen voor: " + game.getGameName());
            for (int i = 1; i <= game.getAmountPlayers(); i++) {
                Player player = Player.createPlayer(i, game);
                players.add(player);
            }
            boolean stopGame = false;
            timesPlayed = 0;
            while (!stopGame) {
                game.playGame(players,timesPlayed);
                stopGame = anotherTime("game");
                timesPlayed++;
            }
            stopPlaying = anotherTime("total");
        }
    }

    // This method is for selecting the game you want to play and returning the game as an object.
    public static Games createGame() {
        Scanner inputScanner = new Scanner(System.in);
        Random random = new Random();
        boolean inputGameNumberSucces = false;
        int gameNumber = 0;
        String[] gameNames = new String[]{" ", "TicTacToe", "VierOpEenRij", "HogerLager", "BlackJack"};

        for (int i = 1; i < gameNames.length; i++) {
            System.out.println(i + " " + gameNames[i]);
        }
        System.out.print("Welk spel wilt U spelen geef aan met het nummer voor de naam ");
        inputGameNumberSucces = false;
        while (!inputGameNumberSucces) {
            try {
                gameNumber = Integer.parseInt(inputScanner.nextLine());
                if (gameNumber > 0 && gameNumber < gameNames.length) {
                    inputGameNumberSucces = true;
                } else {
                    System.out.println("Het moet een getal tussen de 1 en de " + (gameNames.length - 1) + " zijn.");
                    System.out.print("Probeer opnieuw.");
                }
            } catch (Exception e) {
                System.out.println("Het moet een getal tussen de 1 en de " + (gameNames.length - 1) + " zijn.");
                System.out.print("Probeer opnieuw.");
            }
        }

        switch (gameNumber) {
            case 1:
                TicTacToe ticTacToe = new TicTacToe(inputScanner, random);
                return ticTacToe;
            case 2:
                FourInaRow fourInaRow = new FourInaRow(inputScanner, random);
                return fourInaRow;
            default:
                Oops oops = new Oops();
                return oops;
        }
    }

    public static boolean anotherTime(String kind){
        Scanner inputScanner = new Scanner(System.in);
        if(kind == "game") {
            System.out.print("Wilt U dit spel nog een keer spelen? ja/nee");
        }else {
            System.out.print("Wilt U misschien een ander spel spelen? ja/nee");
        }
        String inputString = inputScanner.nextLine();
        System.out.println(inputString);
        char firstLetter = inputString.toLowerCase().charAt(0);
            if (firstLetter == 'j'){
                return false;
            }
        return true;
    }
}
