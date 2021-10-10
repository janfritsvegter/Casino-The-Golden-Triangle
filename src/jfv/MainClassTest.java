package jfv;

public class MainClassTest {
    public static void main(String[] args) {

        System.out.println("Star \u22C6");
        System.out.println("Yingyang \u262F");
        System.out.println("Diamand \u2662");
        System.out.println("Spade \u2664");
        System.out.println("Heart \u2661");
        System.out.println("Club \u2667");

        String[] suits = new String[4];
        suits[0] = "diamonds  \u2666  red";
        suits[1] = "spades  \u2660  black";
        suits[2] = "hearts  \u2665  red";
        suits[3] = "clubs  \u2663  black";

        for (int i = 0; i < suits.length; i++) {
            System.out.println(suits[i]);
        }

    }
}
