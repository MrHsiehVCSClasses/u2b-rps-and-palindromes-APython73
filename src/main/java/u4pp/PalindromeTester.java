package u4pp;
/**
* 
*/
import java.util.Scanner;
public class PalindromeTester {
    /**
     * class checks if a string is a palindrome, ignoring spaces, punctuation and capitalization.
     * main body is execute and ispalindrome method
     * additional helper methods are getYesNoInput and getPhrase
     */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
/// 
/// 
   public static void execute(Scanner sc) {
        System.out.println("Welcome to Palindrome Tester");
        boolean keepTesting = true;
        while (keepTesting) {
            String phrase = getPhrase(sc);

            if (isPalindrome(phrase)) {
                System.out.println(phrase + " is a palindrome");
            } else 
            {
                System.out.println( phrase + " is not a palindrome");
            }
            keepTesting = getYesNoInput("Keep testing? (Y)es or (N)o: ", sc);
            }
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
/// precondition is a inout of a string
/// postcondition is a boolean value of true if the input string is a palindrome and false if it is not
   public static boolean isPalindrome(String phrase) {

        String word = phrase.toLowerCase().replaceAll("[^a-zA-Z]", "");
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.substring(i, i + 1);
        }

        if (word.equals(reversed)) {
            return true;
        } else {
            return false;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    /// preconditions are that the input is a string of characters and
    /// no preconditions.posconditions are that the output is a boolean value of true if user inputs yes (Y),false if user inputs no (N)
    /// this methods prompts the user to input Y/N and asks if they want to play again and loops until a valid answer is given
    private static boolean getYesNoInput(String prompt, Scanner sc) {
    while (true) {
            System.out.print(prompt); 
            String input = sc.nextLine().toUpperCase();

            if (input.equals("Y") || input.equals("YES")) {
                return true;
            }
            if (input.equals("N") || input.equals("NO")) {
                return false;
            } else {
                // Match the error message from the RockPaperScissors sample
                System.out.println("Invalid Input, please try again");
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    /// preconditions are that the input is a string of characters.
    /// postconditions are returns the string
    /// method is to get a input string
    private static String getPhrase(Scanner sc) {
        System.out.print("Enter a phrase: ");
        return sc.nextLine();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
}