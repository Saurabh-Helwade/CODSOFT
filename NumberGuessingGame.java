import java.util.Scanner;
import java.util.Random;


public class NumberGuessingGame {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int maxNumber = 100;
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalAttempts = 0;
        int rounds = 0;

        boolean playAgain = true;
        while(playAgain) 
        {
            int randomNumber = random.nextInt(maxNumber) + 1;
            int guessCount = 0;
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println("      Welcome To The Number Guessing Game !      ");
            System.out.println("-------------------------------------------------");
            System.out.println("Guess any number between 1 to " + maxNumber + "\nYou have " + maxAttempts + " attempts to guess a number");

            while(guessCount < maxAttempts) 
            {
                System.out.print("Enter Your Guess :- ");
                int playerGuess = scanner.nextInt();
                guessCount++;
                totalAttempts++;

                if (playerGuess > randomNumber) 
                {
                    System.out.println("Nope ! The number is Higher. Guess the lower number");
                }
                else if (playerGuess <randomNumber) 
                {
                    System.out.println("Nope ! The number is lower. Guess the Higher number ");
                }
                else 
                {
                    System.out.println("Nice ! You Have Guessed Correct Number");
                    roundsWon++;
                    break;
                }
            }
            System.out.println(" Your current score :- Rounds won - " + roundsWon + ", Total attempts - " + totalAttempts);
            if (guessCount == maxAttempts) 
            {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Would you like to play again ? (y/n) :- ");
            String playAgainChoice = scanner.next();
            playAgain = playAgainChoice.equals("y");
            rounds++;
            System.out.println(" You played "+rounds+ " rounds with total " + totalAttempts+ " attempts and won " +roundsWon+ " rounds.");
        }
        scanner.close();            
    }
}
