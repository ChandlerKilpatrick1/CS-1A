
// You may use the nested comments below as hints only. Remember, there is no one right or wrong way 
// to 'solve' this Assignment, so feel free to delete the comments if you find them distracting.

import java.util.Random;
import java.util.Scanner;

/**
 * CS1A, Assignment 4, "Guessing Game" <br>
 * Quarter: Winter 202 THE CLASS DESCRIPTION GOES HERE <br>
 * THE DESCRIPTION OF HOW TO WIN MOST EFFICIENTLY GOES HERE <br>
 * 
 * @author Nathan Ip
 * @author Chandler Kilpatrick
 * 
 */
public class GuessingGame extends Object
{
   // List any instance variables, including constants, here (like userGuess and
   // numberChoice).
   private static final int MAX_POSSIBLE_GUESS = 50; // This is a constant
   private static final int MIN_POSSIBLE_GUESS = -50;
   private static final int MAX_GUESSES = 7;
   private static int USER_GUESS = 0;
   private static int GUESSES_LEFT = 0;
   private static int secretNumber = 0;
   int[] guessNum = new int[MAX_GUESSES];
   Random randomNumberGenerator = new Random();
   Scanner scanner = new Scanner(System.in);
   
   
   // This method will get a random number. 
   public int getRandomNumber()
   {
      int max = MAX_POSSIBLE_GUESS - MIN_POSSIBLE_GUESS;
      int zeroToMax = randomNumberGenerator.nextInt(max + 1);
      return zeroToMax + MIN_POSSIBLE_GUESS;
   }

   // This method will print the welcome message. 
   public void welcome()
   {
      System.out.println("Welcome to the guessing game!");
      System.out.println("Rules:");
      System.out.println("1) You have " + MAX_GUESSES + " guesses.");
      System.out.println("2) If you guess the number wrong, a hint will be displayed.");
      System.out.println("3) Your guess has to be a whole number between -50 and 50.");
      System.out.println("");

   }

   // This method will combine all the smaller methods into one major one.
   public boolean isGuessNum()
   {
	  
      this.getGuess();
      while (this.hasBeenGuessed())
      {
         System.out.println("You have already guessed this number!");
         this.getGuess();
      }

      while (this.outOfRange())
      {
         System.out.println("Your number is out of range!");
         this.getGuess();

      }
      if (this.isSecretNum())
      {
         System.out.println("You won!");
         return false;
      }
      
      this.updateArray();
      this.hint();
      GUESSES_LEFT--;
      this.printGuesses();

      return true;

   }
   
   
   // This method will print the users previous guesses.
   public void printGuesses()
   {
      System.out.println("Your previous guess(es): ");
      for (int i = 0; i < MAX_GUESSES - GUESSES_LEFT; i++)
      {
         if (i > 0)
         {
            System.out.print(", " + guessNum[i]);
         } else
         {
            System.out.print(guessNum[i]);
         }
      }
      System.out.println("");
      System.out.println("You have " + GUESSES_LEFT + " guesses left.");
      System.out.println("");

   }

   // This method will update the array with user guesses.
   public int[] updateArray()
   {

      guessNum[MAX_GUESSES - (GUESSES_LEFT)] = USER_GUESS;

      return guessNum;
   }
   
 

   // This method will get the user's guess.
   public int getGuess()
   {
      boolean wrongNumber = true;
      do
      {
         System.out.print("Enter a whole number between -50 and 50: ");
         if (scanner.hasNextInt())
         {
            USER_GUESS = scanner.nextInt();
            wrongNumber = false;
         } else
         {
            //scanner.next();
            System.out.println("Please enter a whole number.");
         }
      } while (wrongNumber);
      System.out.println("You guessed: " + USER_GUESS);
      return USER_GUESS;
   }

   
   // This method will determine whether or not the guess is in the correct range.
   public boolean outOfRange()
   {
      if (USER_GUESS <= MAX_POSSIBLE_GUESS && USER_GUESS >= MIN_POSSIBLE_GUESS)
      {

         return false;
      }
      return true;
   }

   
   // This method will determine if the user has repeated a guess.
   public boolean hasBeenGuessed()
   {
      for (int i = 0; i < MAX_GUESSES - GUESSES_LEFT; i++)
      {

         if (USER_GUESS == 0)
         {
            return false;
         } else if (guessNum[i] == USER_GUESS)
         {
            return true;

         }
      }
      return false;
   }

   
   // This method will check if the user's guess is the secret number.
   public boolean isSecretNum()
   {
      int secretNum = secretNumber;
      if (USER_GUESS == secretNum)
      {
         return true;
      } else
      {
         return false;
      }
   }

   
   // This method will print a hint about user guesses.
   public void hint()
   {

      if (USER_GUESS < secretNumber)
      {
         System.out.println("My secret number is GREATER than " + USER_GUESS);
      }
      if (USER_GUESS > secretNumber)
      {
         System.out.println("My secret number is LESS than " + USER_GUESS);
      }

   }

   
   // This method will determine if the user wants to restart the game.
   public boolean playGame()
   {
      boolean counter = true;

      while (counter)
      {
         System.out.println("Enter '1' to play again.");
         System.out.println("Enter '0' to quit.");
         int input = scanner.nextInt();
         if (input == 0)
         {

            counter = false;
            return false;
         } else if (input == 1)
         {

            counter = false;
            return true;
         }
      }
      return false;

   }
   
   
   // This method will reset the guesses.
   public void reset()
   {
      GUESSES_LEFT = MAX_GUESSES;
      int randomNumber = this.getRandomNumber();
      secretNumber = randomNumber;
   }
   
   
   // This method run the guessing game.
   public boolean playGuessingGame()
   {
      this.reset();
      this.welcome();
      boolean play = true;
      while (play)
      {
         play = this.isGuessNum();
         if (GUESSES_LEFT == 0)
         {
            play = false;
         }
      }

      System.out.println("The secret number was " + secretNumber);
      this.reset();
      boolean playAgain = this.playGame();

      return playAgain;

   }

}
