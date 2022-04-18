import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Random random = new Random();
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Cards> playerOneDeck = new ArrayList<>();
    static ArrayList<Cards> playerTwoDeck = new ArrayList<>();

    // name of the two players
    static String player1Name = "";
    static String player2Name = "";

    // win counter for both players
    static int winCountForPlayer1 = 0;
    static int winCountForPlayer2 = 0;

    public static void main(String[] args) {

        System.out.println("Hey whatsup let's play a game of war!");
        System.out.println(
                "-------------------------------------------------------------------------------------------------");
        System.out.println(
                "Player One type your name, please:");
        player1Name = scan.nextLine();

        playerOneDeck = Cards.createStackOne();
        for (int i = 0; i < playerOneDeck.size(); i++) {
            Collections.swap(playerOneDeck, randomizer(), i);
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        System.out.println("Player Two type your name, please:");
        player2Name = scan.nextLine();
        playerTwoDeck = Cards.createStackTwo();
        for (int i = 0; i < playerTwoDeck.size(); i++) {
            Collections.swap(playerTwoDeck, randomizer(), i);
        }
        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        System.out.println("The game begins!");
        System.out.println("Enter 1 to start and 2 to quit");
        int playGame = scan.nextInt();

        System.out.println(
                "-------------------------------------------------------------------------------------------------");

        if (playGame == 1) {

            for (int i = 0; i < 15; i++) {

                Cards playerOneTopCard = playerOneDeck.get(i);
                Cards playerTwoTopCard = playerTwoDeck.get(i);

                System.out.println("Play One's top card is: " + playerOneTopCard);
                System.out.println("VS");
                System.out.println("Play Two's top card is: " + playerTwoTopCard);
                int comparable = playerOneTopCard.compareTo(playerTwoTopCard);
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println("The winner is: " + determineWinner(playerOneTopCard, playerTwoTopCard, comparable)
                        + " in round " + i);

            }
            if (winCountForPlayer1 > winCountForPlayer2) {
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println("The winner after 14 round is PLAYER NUMBER ONE: " + player1Name);
            } else if (winCountForPlayer1 < winCountForPlayer2) {
                System.out.println(
                        "-------------------------------------------------------------------------------------------------");
                System.out.println("The winner after 14 round is PLAYER NUMBER TWO: " + player2Name);

            }

            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
        } else if (playGame == 2) {
            System.out.println("You quit the program");

            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            return;

        }
        System.exit(0);

        // -----------------------------

    }

    // Randomizer method
    static int randomizer() {
        return random.nextInt(56);
    }

    // Determining the winner method here
    static String determineWinner(Cards playOneTopCard, Cards playerTwoTopCard, int comparable) {
        if (comparable == -1) {
            winCountForPlayer1++;
            return player1Name;

        }
        if (comparable == 1) {
            winCountForPlayer2++;
            return player2Name;
        } else {
            return "It's a draw";
        }
    }
}
