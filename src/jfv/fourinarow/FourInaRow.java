package jfv.fourinarow;

import jfv.Games;
import jfv.Player;

import java.util.*;

public class FourInaRow extends jfv.Games{
    private Scanner inputScanner;
    private Random random;
    private String gameName;
    private int amountPlayers;
    private boolean tokenRequired;

    public FourInaRow (Scanner inputScanner, Random random) {
        this.inputScanner = inputScanner;
        this.random = random;
        this.gameName = "Four in a row";
        this.amountPlayers = 2;
        this.tokenRequired = true;
    }

    @Override
    public String getGameName() {
        return this.gameName;
    }

    @Override
    public int getAmountPlayers() {
        return amountPlayers;
    }

    @Override
    public boolean isTokenRequired() {
        return tokenRequired;
    }

    @Override
    public void playGame(List<Player> inputPlayers, int timesPlayed) {
        String[][] board;
        Player player;
        Queue<Player> players;
        boolean isWin = false;
        int move = 0;

        // fillBoardBlank(usedBoard);
        // fillBoard(board);

        players = Games.playersToQue(inputPlayers,timesPlayed);

        board = createBoard();
        int maxMoves = board.length * board[0].length;
        while (!isWin && move < maxMoves) {
            move++;
            player = players.remove();
            printBoard(board);
            isWin = doMove(board, player);
            if(isWin){
                System.out.println(player.getFirstName()+" "+player.getLastName()+" U heeft gewonnen gefeliciteerd");
            }

            players.add(player);
        }

    }

    private String[][] createBoard(){
        int rows; // the amount of rows of the board
        int minRows = 4; // het minimale aantal rijen van het speelveld
        int maxRows = 8; // het maximale aantal rijen van het speelveld
        int defaultRows = 6; // het aantal rijen wat gekozen wordt als het invoeren mislukt
        int columns; // teh amount of columns of the board
        int minColumns = 6; // het minimale aantal rijen van het speelveld
        int maxColumns = 12; // het maximale aantal rijen van het speelveld
        int defaultColumns = 8; // het aantal rijen wat gekozen wordt als het invoeren mislukt
        int maxTries = 5; // maximaal aantal keren dat iemand het aantal rijen of kolommen mag proberen in te voeren
        String emptyVallue = " ";

        //Maak het bord
        System.out.println("Wat zijn de dimensies van het speelveld");
        System.out.println("Hoeveel kolommen heeft het speelveld");
        System.out.println("een geheel getal tussen de " + minColumns + " en de " + maxColumns);

        columns = inputInteger(minColumns,maxColumns,defaultColumns,maxTries);
        System.out.println(columns);

        System.out.println("hoeveel rijen heeft het speelveld?");
        rows = inputInteger(minRows,maxRows,defaultRows,maxTries);
        System.out.println(rows);

        String[][] board = new String[columns][rows];
        fillBoard(board,emptyVallue);

        return board;
    }

    // Gives an integer back between min and max endpoints included
    // and after a max amount of tries a default vallue
    private int inputInteger(int min, int max, int def, int maxTries){
        Scanner inputScanner = new Scanner(System.in);
        int noTries = 0;
        boolean inputSucces = false;
        int inputVallue = 0;
        while (!inputSucces) {
            if(noTries==0){
                System.out.println("Je moet eem geheel getal invoeren tussen de " + min + " en de " + max);
            }
            else{
                System.out.println("Je moet eem geheel getal invoeren tussen de " + min + " en de " + max + " probeer opnieuw");
            }
            String temp = inputScanner.nextLine();
            // System.out.println(noTries);
            try {
                inputVallue = Integer.parseInt(temp);
                if(inputVallue>=min && inputVallue <=max){
                    inputSucces = true;
                }
                else {
                    System.out.println("Het getal moet wel tussen de " + min + " en de " + max + " liggen");
                }
            }catch (Exception e){
                System.out.println(e);
                System.out.println("Het moet wel een  geheel getal zijn");
                System.out.println("En het getal moet wel tussen de " + min + " en de " + max + " liggen");
            }
        }
        return inputVallue;
    }

    // Fills the board with a vallue for empty fields
    private void fillBoard(String[][] board, String emptyVallue){
        for (int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++ ){
                board[i][j] = emptyVallue;
            }

        }

    }

    // prints the board
    private void printBoard(String[][] board){
        for( int i = (board[0].length -1); i >=0 ; i-- ){
            System.out.print("  ");
            for (int j = 0; j < board.length; j++){
                if (j < (board.length -1)){
                    System.out.print( board[j][i] + "  |  ");
                }
                else {
                    System.out.println(board[j][i]);
                }
            }
        }
        System.out.print("--");
        for (int i = 1; i <= board.length; i++) {
            System.out.print("-----");
        }
        System.out.println("------");
        System.out.print("  ");
        for (int i = 1; i <= board.length; i++){
            if (i < board.length){
                if ( i <9 ){
                    System.out.print( i + "  |  ");
                }
                else{
                    System.out.print( i + "  | ");
                }
            }
            else {
                System.out.println(i);
            }
        }

    }

    private boolean doMove(String[][] board, Player player){

        return false;
    }


}


