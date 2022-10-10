import java.util.Scanner;
import java.util.Random;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();


        //declare variables
        int playerCardValue = 0;
        int playerHand = 0;
        int totalGames = 1;
        int playerWins = 0;
        int dealerHand = 0;
        int dealerWins = 0;
        int numOfTies = 0;
        boolean gameOver = false;

        while (!gameOver) {
            //when playerHand is 0, that indicates that the game has been reset (new game has started)
            if (playerHand == 0) {
                System.out.println("\nSTART GAME #" + totalGames);

                playerCardValue = rand.nextInt(13) + 1;
                if (playerCardValue == 1) {
                    System.out.println("\nYour card is a ACE!");
                } else if (playerCardValue == 11) {
                    System.out.println("\nYour card is a JACK!");
                } else if (playerCardValue == 12) {
                    System.out.println("\nYour card is a QUEEN!");
                } else if (playerCardValue == 13) {
                    System.out.println("\nYour card is a KING!");
                } else {
                    System.out.println("\nYour card is a " + playerCardValue + "!");
                }

                //determine the player's hand
                if (playerCardValue > 0 && playerCardValue < 11) {
                    playerHand = playerHand + playerCardValue;
                } else if (playerCardValue > 10) {
                    playerHand += 10;
                }
                System.out.println("Your hand is: " + playerHand);
            }

            //present the menu and store the player's choice in menuChoice
            System.out.println("\n1. Get another card");
            System.out.println("2. Hold hand");
            System.out.println("3. Print statistics");
            System.out.println("4. Exit");
            System.out.println("\nChoose an option: ");
            int menuChoice = scanner.nextInt();

            //1: give the player a new card
            if (menuChoice == 1) {
                playerCardValue = rand.nextInt(13) + 1;
                if (playerCardValue == 1) {
                    System.out.println("\nYour card is a ACE!");
                } else if (playerCardValue == 11) {
                    System.out.println("\nYour card is a JACK!");
                } else if (playerCardValue == 12) {
                    System.out.println("\nYour card is a QUEEN!");
                } else if (playerCardValue == 13) {
                    System.out.println("\nYour card is a KING!");
                } else {
                    System.out.println("\nYour card is a " + playerCardValue + "!");
                }

                if (playerCardValue > 0 && playerCardValue < 11) {
                    playerHand = playerHand + playerCardValue;
                } else if (playerCardValue > 10) {
                    playerHand += 10;
                }
                System.out.println("Your hand is: " + playerHand);

                //determine the game's flow based on the player's hand
                if (playerHand == 21){
                    System.out.println("BLACKJACK! You win!");
                    playerWins ++;
                    totalGames ++;
                    playerHand = 0;
                    dealerHand = 0;
                } else if (playerHand > 21) {
                    System.out.println("You exceeded 21! You lose.");
                    totalGames++;
                    dealerWins++;
                    playerHand = 0;
                    dealerHand = 0;
                }

            //2: give the dealer's hand and compare dealerHand to playerHand
            } else if (menuChoice == 2) {
                dealerHand = rand.nextInt(11) + 16;
                //player automatically wins if the dealer's hand is more than 21
                if (dealerHand > 21){
                    System.out.println("\nDealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("\nYou win!");
                    playerWins ++;
                    totalGames ++;
                    playerHand = 0;
                    dealerHand = 0;

                //tie game scenario
                } else if (dealerHand == playerHand){
                    System.out.println("\nDealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("\nIt's a tie! No one wins!");
                    totalGames ++;
                    numOfTies ++;
                    playerHand = 0;
                    dealerHand = 0;

                 //scenario in which dealer wins
                } else if (dealerHand > playerHand) {
                    System.out.println("\nDealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("\nDealer wins!");
                    dealerWins ++;
                    totalGames ++;
                    playerHand = 0;
                    dealerHand = 0;

                //scenario in which player wins
                } else if (dealerHand < playerHand){
                    System.out.println("\n1Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + playerHand);
                    System.out.println("\nYou win!");
                    playerWins++;
                    totalGames++;
                    playerHand = 0;
                    dealerHand = 0;
                }

            //print game summary
            } else if (menuChoice == 3){
                System.out.println("Number of Player wins: " + playerWins);
                System.out.println("Number of Dealer wins: " + dealerWins);
                System.out.println("Number of tie games: " + numOfTies);
                System.out.println("Total # of games played is: " + (totalGames - 1));
                double percentageOfPlayerWins = playerWins * 100.0/ (totalGames - 1);
                System.out.println("Percentage of Player wins: " + percentageOfPlayerWins + "%");

            //exit game scenario
            } else if (menuChoice == 4){
                System.exit(0);
                
            //alert to correct inappropriate input
            } else {
                System.out.println("\nInvalid input! \nPlease enter an integer value between 1 and 4.");
            }
        }
    }
}