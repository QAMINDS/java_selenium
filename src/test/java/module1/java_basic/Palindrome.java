package module1.java_basic;

import java.util.Scanner;

/*
    Write a Java program which ask the user to
    input a string, and prints True if the string is
    a palindrome.
"*/
public class Palindrome {
    public static void main(String[] args){
        System.out.println("Enter string: ");
        Scanner scanner = new Scanner(System.in);
        String palindrome = scanner.nextLine();
        for (char tmp: palindrome.toCharArray()) {
            System.out.println(tmp);
        }
    }
}
