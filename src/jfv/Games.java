package jfv;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public abstract class Games {

    public String getGameName(){return "foutje bedankt";}

    public int getAmountPlayers(){return 0;}

    public boolean isTokenRequired(){return false;}

    public void playGame(List<Player> inputPlayers,int timesPlayed){}
}
