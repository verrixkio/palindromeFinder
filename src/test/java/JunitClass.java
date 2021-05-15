import org.junit.jupiter.api.Test;
import palindrome.palindromeFinder;
import static org.junit.jupiter.api.Assertions.*;

public class JunitClass {
    @Test
    public void isPalindromeTest() {
        assertTrue(palindromeFinder.isPalindrome("12321"));
        assertFalse(palindromeFinder.isPalindrome("12322"));
        System.out.println("isPalindrome is working as intended");
    }

    @Test
    public void Assertions() {
        int comparedValue = palindromeFinder.comparePalindrome(121, 131, 123);
        assertEquals(121, comparedValue );

        int inputNumberOne = 1800;
        assertEquals(1771, palindromeFinder.findLowPalindrome(inputNumberOne));

        int inputNumberTwo = 1800;
        assertEquals(1881, palindromeFinder.findHighPalindrome(inputNumberTwo));

        int inputNumberThree = 123;
        assertEquals(121, palindromeFinder.findLowPalindrome(inputNumberThree));

        int inputNumberFour = 123;
        assertEquals(131, palindromeFinder.findHighPalindrome(inputNumberFour));

        System.out.println("Assertions are working as intended");
    }
}
