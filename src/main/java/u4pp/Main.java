package u4pp;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        //test for rockPaperScissors methods
        RockPaperScissors.rockPaperScissors(args);
        Scanner sc = new Scanner(System.in);
        RockPaperScissors.play(sc);
        sc.close();
        //test for ispanindrome method
        System.out.println(PalindromeTester.isPalindrome("test"));
        Scanner myScanner = new Scanner(System.in);
        PalindromeTester.execute(myScanner);
        myScanner.close();
    }
    
}
