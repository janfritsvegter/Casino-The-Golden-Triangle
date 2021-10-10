package jfv;

import java.util.Scanner;

public class Player {
    // private Scanner inputScanner;
    private String firstName;
    private String lastName;
    private String token;


    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = ".";
    }


    public Player(String firstName, String lastName, String token) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompleteName() {
        return this.firstName + " " + this.lastName;
    }
    public String toString(){
        return this.firstName + " " + this.lastName + " speelt met " + token;
    }

    // This method creates the player objects.
    // In the attribute playerOptions is the special possibilities needed for the game.
    public static Player createPlayer(int number, Games game) {
        String token = " ";
        Player player;
        System.out.print("Speler " + number + " wat is je voornaam? ");
        String firstName = inputString();
        System.out.print("Speler " + number + " wat is je achternaam? ");
        String lastName = inputString();

        // TODO tokenrequired  uitbreiden naar meer moegelijkheden zoals extra class player
        String playerOptions = game.getPlayerOptions();
        if (playerOptions.equals("token")) {
            System.out.print(firstName + " " + lastName + " ");
            token = inputToken(" ");
            player = new Player(firstName,lastName,token);
        }else if (playerOptions.equals("cardGame")){
            player = new Player(firstName,lastName,token);
        }else{
            player = new Player(firstName,lastName);
        }



        return player;
    }

    public static String inputToken(String tokenOtherPlayer){
        String Token = " ";
        boolean inputSucces = false;
        System.out.print("met wat voor teken wil je spelen (1 letter) bij meerdere tekens wordt de eerste genomen ");
        while (!inputSucces) {
            String inputToken = inputString();
            Token = Character.toString(inputToken.charAt(0));
            if (Token != tokenOtherPlayer) {
                inputToken = String.valueOf(inputToken);
                inputSucces = true;
            } else {
                System.out.println("Het mag geen " + tokenOtherPlayer + " zijn probeer opnieuw");
            }
        }
        return Token;
    }

    private static String inputString(){
        Scanner inputScanner = new Scanner(System.in);
        boolean inputSucces = false;
        while (!inputSucces) {
            String inputString = inputScanner.nextLine();
            if (inputString != ""){
                return inputString;
            }else{
                System.out.println("Je moet wel iets invullen hoor probeer opnieuw.");
            }
        }
        return "QWERTY";
    }

}
