package ChallengeOne.Functions;

public class CheckPalindrome {

    public static void main(String[] args) {

        checkPalindrome("Madam");
        checkPalindrome("Arara");
        checkPalindrome("Civic");
        checkPalindrome("Radar");
        checkPalindrome("Guilherme");

    }

    private static void checkPalindrome(String string) {
        String reverse = new StringBuffer(string).reverse().toString();

        if (string.toLowerCase().equals(reverse.toLowerCase())) {
            System.out.println("Is a Palindrome!");
        } else {
            System.out.println("Not is a Palindrome!");
        }

    }
}
