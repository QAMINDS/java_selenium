package module1.java_basic;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        System.out.println("Enter string: ");

        Scanner scanner = new Scanner(System.in);
        String captura = scanner.nextLine();
        String formatted = captura.toLowerCase().replaceAll("[^a-z]", "");

        String reverso = new StringBuilder(formatted).reverse().toString();

        System.out.println(formatted.equals(reverso));
    }
}
