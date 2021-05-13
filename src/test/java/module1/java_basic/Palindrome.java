package module1.java_basic;
import java.util.Scanner;
import java.util.*;

public class Palindrome {
    public static void main(String[] args){

        System.out.println("Enter String: ");

        Scanner scanner = new Scanner(System.in);
        String palindrome = scanner.nextLine();

        String alrevez = ""; // Objects of String class
        int length = palindrome.length();
        for ( int i = length - 1; i >= 0; i-- )
            alrevez = alrevez + palindrome.charAt(i);
        if (palindrome.equals(alrevez))
            System.out.println(palindrome + " is a palindrome.");
        else
            System.out.println(palindrome + " isn't a palindrome.");
    }

}
