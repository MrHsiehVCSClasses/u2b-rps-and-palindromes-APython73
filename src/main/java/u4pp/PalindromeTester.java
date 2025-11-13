package u4pp;
/**
* 
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * YOUR JAVADOC HERE
     */
   public static void execute(Scanner sc) {
        // Prompt for phrase
        System.out.println("Welcome to Palindrome Tester");
        boolean keepTesting = true;

        while (keepTesting) {
            String phrase = getPhrase(sc);

            // Check if palindrome and display result
            if (isPalindrome(phrase)) {
                System.out.println(phrase + " is a palindrome");
            } else 
            {
                System.out.println( phrase + " is not a palindrome");
            }

            // Ask if they want to continue
            keepTesting = getYesNoInput("Keep testing? (Y)es or (N)o: ", sc);
            }
    }

    /**
     * YOUR JAVADOC HERE
          */
   public static boolean isPalindrome(String phrase) {
        // 1. Filter the string
        String input = getPhrase(sc);
        int length = cleaned.length();

        // 2. Check if the filtered string is a palindrome using a for loop
        // We only need to loop up to the middle of the string
        for (int i = 0; i < length / 2; i++) {
            // Compare the character from the start with the corresponding character from the end
            if (cleaned.charAt(i) != cleaned.charAt(length - 1 - i)) {
                return false; // Characters don't match
            }
        }

        return true; // All characters matched
    }

    /* Any helper methods you might need */

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    private static boolean getYesNoInput(String prompt, Scanner sc) {
    while (true) {
            System.out.print(prompt); // Use print to match sample run
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

    private static String getPhrase(Scanner sc) {
        System.out.print("Enter a phrase: ");
        return sc.nextLine();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
}