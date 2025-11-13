package u4pp;
/**
* this class is for the game rock paper scissors
*main methods are rockPaperScissors and play, which use helper methods
*helper methods are getRandomChoice, getPlayerChoice, getYesNoInput, formatChoice, playRound, and results
*/
import java.util.Scanner;

public class RockPaperScissors {

  //declare scanner which should be used for all methods, wll be closed in main method

    public static void rockPaperScissors(String[] args) {
      Scanner scan = new Scanner(System.in);
      play(scan);
      scan.close();
    }
    

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //preconditions are that the inputs are valid R/P/S (must be capitalized), no post conditions.
    //returns 0 for a tie or unexpected input, 1 for a player win and -1 for a computer win.
    public static int results(String playerChoice, String computerChoice) { 
      playerChoice = playerChoice.toUpperCase();
      computerChoice = computerChoice.toUpperCase();
      //player wins
           if(playerChoice.equals("R") && computerChoice.equals("S") ||  playerChoice.equals("S") && computerChoice.equals("P") ||  playerChoice.equals("P") && computerChoice.equals("R"))
              {
            return 1;
              }   
      //computer wins
          else if(computerChoice.equals("R")  && playerChoice.equals("S") || computerChoice.equals("S")  && playerChoice.equals("P") || computerChoice.equals("P")  && playerChoice.equals("R"))
             {
            return -1;
             }
      //tie or unexpected inputs
            else
              {
            return 0;
              }
       }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //no preconditions. 
    //posconditions is that the output is a random letter of R,P or S (Capitalized).
    private static String getRandomChoice() {    
    int number = (int)(Math.random() * 3);
     if(number == 0) 
      {
      return "P";
      }
    else if(number == 1) 
      {
      return "S";
      }
    else if(number == 2) 
      {
      return "R";
      }

    //default return statement to avoid errors, should never be reached
    else
      {
      return "bad input / something wrong with randomchoice";
      } 
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 //preconditions are that player put in a input, postconditions are that. posconditions are that ouput is the player's choice
 // this method prompts the user to input a choice and returns it as a capitalized one letter string (R,S, or S)
 // also handles the inut a, ehich returns a random choice for the player
    private static String getPlayerChoice(Scanner sc) {    
      while(true)     
      {
        System.out.println("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny");
        String input = sc.nextLine().toUpperCase();
        

        if(input.equals("R") || input.equals("P") || input.equals("S"))
           {
        return input;
           }
        else if(input .equals("A")) 
           {
        return getRandomChoice();
           }
        else
          {
          System.out.println("invalid input, please try again");
          }
      }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /*no preconditions.posconditions are that the output is a boolean value of true if user inputs yes (Y),
    false if user inputs no (N)
    this methods prompts the user to input Y/N and asks if they want to play again and loops until a valid answer is given
     */
    private static boolean getYesNoInput(String prompt, Scanner sc) {   
    while(true)
    {    
        System.out.println(prompt);
        String input = sc.nextLine().toUpperCase();
  
      if(input.equals("Y"))
        {
        return true;
        }
      if(input.equals("N") || input.equals("NO"))
        {
         return false;
        }
      else 
        {
    System.out.println("invalid input");
        }
    }
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //preconditions are that the input is a capitalized letter of R, P, or S.
   // postconditions are that the output is the full name of the choice (Rock,Paper, or Scissors)
    private static String formatChoice(String input) {
      if(input.equals("R"))
        {
      return "Rock";
        }
      else if(input.equals("P"))
        {
      return "Paper";
        }
      else if(input.equals("S"))
        {
      return "Scissors";
        }
      else
        {
      return "bad input";
        }
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static void playRound(int[] scores, Scanner sc) {
      String compChoice = getRandomChoice();
      String playerChoice = getPlayerChoice(sc);
      int result = results(playerChoice, compChoice);
      if(result == 1) //player win
        {
        System.out.println("You win!");
        scores[0]++;  
        }
      else if(result == -1) //computer win
        {
        System.out.println("You lose!");
        scores[1]++;
        }
      else //tie or unexpected input
        {
        System.out.println("It's a tie!");
        scores[2]++;
        }
      System.out.println("You chose " + formatChoice(playerChoice) + " and the computer chose " + formatChoice(compChoice));  
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
 public static void play(Scanner sc) {
        int[] scores = { 0, 0, 0 };
        boolean playAgain = true;

        System.out.println("Welcome to Rock Paper Scissors");

        while (playAgain == true)
           {
          playRound(scores,sc);
          System.out.println("You have " + scores[0] + " wins " + scores[1] + " losses and " + scores[2] + " ties");
          playAgain = getYesNoInput("Do you want to play again? (Y/N)", sc);
           }
        System.out.println("Thanks for playing!");
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
}