package module1.java_basic;

import java.util.Scanner;

/*
    Write a Java program which ask the user to
    input a string, and prints True if the string is
    a palindrome.
"*/
public class PalindromeSolution {
    public static void main(String[] args){
        System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String palindrome = scanner.nextLine().toLowerCase();
        palindrome = palindrome.replaceAll("[^a-z]", "");
        System.out.println(isPalindrome(palindrome));
    }

    private static boolean isPalindromeEasy(String value) {
        String reversed = new StringBuilder(value).reverse().toString();
        return value.equals(reversed);
    }

    private static boolean isPalindrome(String value) {
        int start = 0;
        int end = value.length() - 1;
        while (start < end) {
            if (value.charAt(start) != value.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
