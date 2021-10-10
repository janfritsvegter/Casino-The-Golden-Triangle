package jfv.blackjack;

public class Card {
    private CardSuit suit;
    private CardValue value;

    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public CardValue getValue() {
        return value;
    }

    public String render(){
        return "";
    }
}
