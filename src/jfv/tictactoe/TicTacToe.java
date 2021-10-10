package jfv.tictactoe;

import jfv.Player;

import java.util.*;

public class TicTacToe extends jfv.Games {
    private String gameName;
    private int amountPlayers;
    private String playerOptions;

    public TicTacToe() {
        this.gameName = "TicTacToe";
        this.amountPlayers = 2;
        this.playerOptions = "token";
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
    public String getPlayerOptions() {
        return playerOptions;
    }


    @Override
    public void playGame(List<Player> inputPlayers,int timesPlayed) {
        String[] board = new String[9];
        String[] usedBoard = new String[9];
        Player player;
        Queue<Player> players = new LinkedList<>();
        boolean isWin = false;
        int move = 0;

        fillBoardBlank(usedBoard);
        fillBoard(board);

// put the players from a ArrayList in a Queue
// A Queue is used for thr fifo to easyly change players
        // If the game is played for the second time the order should reverse
        if(timesPlayed%2==0) {
            for (int i = 0; i < inputPlayers.size(); i++) {
                players.add(inputPlayers.get(i));
            }
        }else{
            for (int i = (inputPlayers.size() - 1); i >= 0 ; i--) {
                players.add(inputPlayers.get(i));
            }
        }

        while (!isWin && move < 9) {
            move++;
            player = players.remove();
            isWin = doMove(board, player, usedBoard);
            if(isWin){
                System.out.println(player.getFirstName()+" "+player.getLastName()+" U heeft gewonnen gefeliciteerd");
            }

            players.add(player);
        }


    }

    private void fillBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.toString(i + 1);
        }
    }

    private void fillBoardBlank(String[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = " ";
        }
    }

    private void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            if ((i + 1) % 3 != 0) {
                System.out.print(board[i] + " | ");
            } else {
                System.out.println(board[i]);
                System.out.println("---------");
            }
        }
    }

    private boolean doMove(String[] board, Player player, String[] usedBoard) {
        printBoard(board);
        Scanner inputScanner = new Scanner(System.in);
        String token = player.getToken();
        String firstName = player.getFirstName();
        String lastName = player.getLastName();
        boolean goodMove = false;

        int position = 0;
        System.out.print(firstName + " " + lastName + " op welke positie wilt U Uw " + token + " Plaatsen? ");

        while (!goodMove) {
            String positionString = inputScanner.nextLine();
            try {
                position = Integer.parseInt(positionString);
                if (position >= 1 && position <= 9) {
                    if (usedBoard[position - 1] == " ") {
                        board[position - 1] = token;
                        usedBoard[position - 1] = "used";
                        goodMove = true;
                    } else {
                        System.out.println("Het veld mag niet al gebruikt zijn probeer opnieuw");
                    }

                } else {
                    System.out.println("Het getal moet wel tussen de " + 1 + " en de " + 9 + " liggen");
                    System.out.println("En het veld mag nog niet gebruikt zijn");
                }

            } catch (Exception e) {
                System.out.println("Het moet wel een geheel getal zijn probeer opnieuw");

            }

        }
        boolean isWin = winCheck(position, board, player);
        return isWin;
    }

    private boolean winCheck(int position, String[] board, Player player) {
        String token = player.getToken();
        switch (position) {
            case 1:
                if (board[0] == token && board[1] == token && board[2] == token) {
                    return true;
                } else if (board[0] == token && board[3] == token && board[6] == token) {
                    return true;
                } else if (board[0] == token && board[4] == token && board[8] == token) {
                    return true;
                } else {
                    return false;
                }

            case 2:
                if (board[0] == token && board[1] == token && board[2] == token) {
                    return true;
                } else if (board[1] == token && board[4] == token && board[7] == token) {
                    return true;
                } else {
                    return false;
                }

            case 3:
                if (board[0] == token && board[1] == token && board[2] == token) {
                    return true;
                } else if (board[2] == token && board[5] == token && board[8] == token) {
                    return true;
                } else if (board[2] == token && board[4] == token && board[6] == token) {
                    return true;
                } else {
                    return false;
                }

            case 4:
                if (board[3] == token && board[4] == token && board[5] == token) {
                    return true;
                } else if (board[0] == token && board[3] == token && board[6] == token) {
                    return true;
                } else {
                    return false;
                }

            case 5:
                if (board[3] == token && board[4] == token && board[5] == token) {
                    return true;
                } else if (board[1] == token && board[4] == token && board[7] == token) {
                    return true;
                } else if (board[0] == token && board[4] == token && board[8] == token) {
                    return true;
                } else if (board[2] == token && board[4] == token && board[6] == token) {
                    return true;
                } else {
                    return false;
                }

            case 6:
                if (board[3] == token && board[4] == token && board[5] == token) {
                    return true;
                } else if (board[2] == token && board[5] == token && board[8] == token) {
                    return true;
                } else {
                    return false;
                }

            case 7:
                if (board[0] == token && board[3] == token && board[6] == token) {
                    return true;
                } else if (board[6] == token && board[7] == token && board[8] == token) {
                    return true;
                } else if (board[2] == token && board[4] == token && board[6] == token) {
                    return true;
                } else {
                    return false;
                }

            case 8:
                if (board[1] == token && board[4] == token && board[7] == token) {
                    return true;
                } else if (board[6] == token && board[7] == token && board[8] == token) {
                    return true;
                } else {
                    return false;
                }

            case 9:
                if (board[6] == token && board[7] == token && board[8] == token) {
                    return true;
                } else if (board[2] == token && board[5] == token && board[8] == token) {
                    return true;
                } else if (board[0] == token && board[4] == token && board[8] == token) {
                    return true;
                } else {
                    return false;
                }

            default:
                return false;
        }
    }
}
