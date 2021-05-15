## Palindrome Finder

### Description
This method finds that nearest Palindrome to a given input number on the command line.

Example:
```java
//Input: "123"
//Output: "121"
```

### Assumptions: 
* If there is a tie in the absolute difference of output then the lower number is used.
* The provided string does not exceed more than 11 digits. (No BigInt)
* No negative numbers are provided to the input. (Easy error handling to solve this to whomever wants a better 
  solution.)
* Number format like 00000 returns 1.  
* Input does not contain anything but numbers.

### Solution:

Most importantly please see:
`src->main->java->palindrome->palindromeFind.java` for the working solution.

The solution solves the problem through taking a number and checking each number above and below the provided input.
It compares each number to evaluate if it's a palindrome and if so returns the value. Lastly, we compare the 
absolute value of the two possible values to determine which one is closer to the input number.

#### Test Cases
Items tested:
* Check if isPalindrome functions as intended
* Check if compareValues functions as intended
* Checks finding a palindrome for odd/even of higher and lower values.
  
 Bonus - For the more efficient solution and ours:
* Input 1800 returns 1771 knows to search lower


### Learnings

There are two ways I found to solve this problem. One is more efficient from a Time Complexity/Space Complexity 
perspective and one is easier to code but utilizes a more brute force solution. 

I did a decent amount of the math proofing to find the right algorithm but ultimately started running out of time. A 
working solution is better than a theoretical solution haha. :sunrise_over_mountains:

Once I got the palindrome I started doing the math proof:

```java


// Create Palindrome is working. (See Bottom of Post)

// The solution above assumes that the palindrome that is lower is always closest. I'm going to assume that this is not always the case due to the tie condition in the question. On that assumption there needs to be a way to check the upper and lower values. 

// First instinct is to write a loop that checks each number above and below the palindrome to find the nearest palindrome. Though for higher numbers the processing time will begin to increase.

// One option is to handle the two nearest palindromes in the middle by substituting the middle digit. 


// Math Check.

//  1. Palindrome function:

  // So why switch the middle digits and not the others? 
  // Lets say we have a number - 1234.
  // If we create a palindrome from the first 2 digits we get: 1221
  // If we create a palindrome from the last 2 digits we get: 4334
  // |1234 - 4334| = 3100
  // |1234 - 1221| = 13

  // Easy enough, lets consider a variable number of abcd

  // Changing `cd` to the `ab` position reflects a change in the 1000's and 100's spot whereas changing `ab` to the`cd` spot reflects a change in the 10's spot and the 1's spot. The factor of how much they change is the difference between the variables in those spots. 
  //(Example a moving to d is changing the 1000 place to the 4000 place which determine a change of 3000 )

  // |1000(a-d) + 100(b-c)| vs |10(c-b) + 1(d-a)|

  // The closer palindrome will always be closer by substituting the last digits.


//  2. How to ensure that we are getting the closest palindrome not just the one that's closest that's lower.

// When would this happen? How can I check to see when it happens? Well the above solution guarantees the minimum palindrome - the higher palindrome is our consideration this time. We can't check by switching the higher case because that generates high factors.

// Simplest way is by increasing the middle digit by a factor of one. 

// Lets try a number: 1800
// 1881 is a high
// 1771 is a low - my solution won't cover

// This changes my understanding of the problem.

// So I can generate A palindrome  but not necessarily the lowest. 
// So to check the highest and lowest there needs to be a outlying case for when the middle digit changes the higher factorif the middle digit is 0 or 9!

// 1850

//1881
//1771

// So I need to run a check that creates options now.

// Lets try this again
// Create a palindrome

//Here are the cases
//1234
//123

//When even you need to check the case of higher and lower.

//1221
//1331
//1111

//When odd 
//131
//121
//111

//......
```

At this point I recognized that I'd be better off handling a more brute force solution as I started seeing all the 
outlying cases. 

* If a number is 9 or 0
* Numbers like 1800 create a palindrome at 1881 rather than 1771.
* Splitting the odd vs even input to properly reverse and build the palindrome.
* and more I'm sure hah :hourglass: 

For those still reading here is my un-factored create palindrome code:
```java
import java.util.Scanner;

public class palindromeATB {

    public static void main(String[] args) {
        // take input
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Number to Find Palindrome: ");

        String str = scan.nextLine();
        System.out.println(createPalindrome(str));
    }

    public static String reverseStringData(String s) {
        String rev = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }
        return rev;
    }

    public static String createPalindrome(String s) {
        // Initialize new String for the Palindrome.
        String palindrome = new String();
        // Length
        int length = s.length();

        //Middle of the string.
        int middleOfString = (s.length() / 2);

        // Checking upper and lesser values of Even
        char middleChar = s.charAt(middleOfString - 1);
        onePlusMiddleChar = middleChar + 1;

        // Cut the string in half.
        if (length % 2 == 0) {
            // Reverse that part of the string.
            String initialChars = s.substring(0, middleOfString);
            String reverseStr = reverseStringData(initialChars);
            palindrome = initialChars + reverseStr;
        } else {
            String initialChars = s.substring(0, middleOfString);
            String oddChars = s.substring(0, middleOfString + 1);
            String reverseStr = reverseStringData(oddChars);
            palindrome = initialChars + reverseStr;
        }

        for(int i=s.length()-1; i>=0; i--){
        }

        System.out.println(palindrome + " here is the palindrome");
        return "end";
    }
}
```

