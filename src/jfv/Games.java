package jfv;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Games {

    public String getGameName(){return "foutje bedankt";}

    public int getAmountPlayers(){return 0;}

    public String getPlayerOptions() {
        return " ";
    }

    public void playGame(List<Player> inputPlayers,int timesPlayed){}

    public static Queue playersToQue(List<Player> inputPlayers,int timesPlayed){
        Queue<Player> players = new LinkedList<>();
        if(timesPlayed%2==0) {
            for (int i = 0; i < inputPlayers.size(); i++) {
                players.add(inputPlayers.get(i));
            }
        }else{
            for (int i = (inputPlayers.size() - 1); i >= 0 ; i--) {
                players.add(inputPlayers.get(i));
            }
        }
        return players;
    }
}
