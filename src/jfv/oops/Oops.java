package jfv.oops;


public class Oops extends jfv.Games {
    private String gameName;

    public Oops() {
        this.gameName = "Oops hier ging iets mis!";
        //      this.deck = new Deck();
    }

    @Override
    public String getGameName() {
        return gameName;
    }
}
