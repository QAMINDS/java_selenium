package module1.java_basic;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args){

        System.out.println("Enter String: ");

        Scanner scanner = new Scanner((System.in));
        String palindrome = scanner.nextLine();

        char[] characters = palindrome.toCharArray();
        char[] back = new char[characters.length];
        int num = 0;
        for(int i = characters.length; i>0; i--){
            back[num] = characters[i-1];
            num++;
        }
        String back2 = new String(back);
        if(palindrome.equalsIgnoreCase(back2)){
            System.out.println("Es palindromo");
        } else {
            System.out.println("No es palindromo");
        }

    }

}

