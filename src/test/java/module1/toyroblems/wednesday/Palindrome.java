package module1.toyroblems.wednesday;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){
        System.out.println("Hello QA Minds");

        boolean isPalindrome = true;
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        word = word.replaceAll("\\s+","");
        char[] wordArray = word.toCharArray();
        int initialCharacter = 0;
        int lastCharacter = wordArray.length-1;

        while (initialCharacter < lastCharacter) {

            if (wordArray[initialCharacter] != wordArray[lastCharacter]) {
                isPalindrome = false;
                break;
            }
            initialCharacter++;
            lastCharacter--;
        }

        if (isPalindrome) {
            System.out.println( word + " is a palindrome.");
        } else {
            System.out.println( word + " is Not a palindrome.");
        }
    }
}
