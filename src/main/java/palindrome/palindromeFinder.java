package palindrome;
import java.util.Scanner;

//The palindromeFinder is a function that given an input returns that inputs closest palindrome.
public class palindromeFinder {

    public static boolean isPalindrome(String palindrome) {
        int rightString = palindrome.length() - 1;
        int leftString = 0;
        while (leftString < rightString) {
            if (palindrome.charAt(leftString) != palindrome.charAt(rightString)) {
                return false;
            }
            rightString--;
            leftString++;
        }
        return true;
    }

    public static int findLowPalindrome(int num) {
        // Start with searching below the current number to avoid outlying case of a number that is a palindrome.
        int lowNum = num - 1;
        while(!isPalindrome(Integer.toString(lowNum))) {
            lowNum--;
        }
        return lowNum;
    }

    public static int findHighPalindrome(int num) {
        // Start with searching above the current number to avoid outlying case of a number that is a palindrome.
        int highNum = num + 1;
        while(!isPalindrome(Integer.toString(highNum))) {
            highNum++;
        }
        return highNum;
    }

    public static int comparePalindrome(int lowPalindrome, int highPalindrome, int inputNumber) {
        int absLow = Math.abs(lowPalindrome - inputNumber);
        int absHigh = Math.abs(highPalindrome - inputNumber);
        if (absLow > absHigh) {
            return highPalindrome;
        }
        else return lowPalindrome;
    }

    // Input and Main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any positive number to find the closest palindrome: ");
        String str = scan.nextLine();

        int inputNumber = Integer.parseInt(str);
        int lowestPalindrome = findLowPalindrome(inputNumber);
        int highestPalindrome = findHighPalindrome(inputNumber);

        //Compare and print results.
        System.out.println(comparePalindrome(lowestPalindrome, highestPalindrome, inputNumber));
    }
}
