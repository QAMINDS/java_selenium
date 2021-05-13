package module1.java_basic;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args){
        System.out.println("Enter String: ");
        Scanner scanner = new Scanner(System.in);

        String palindrome = scanner.nextLine();
        int lengthPalindrome=palindrome.length();
        int position =lengthPalindrome;


        Boolean isPalindromo = true;
        for (char tmp : palindrome.toCharArray()){

            if(tmp==palindrome.charAt(position-1)){
                position--;
                if(position==lengthPalindrome/2){
                    break;
                }
            }else{
                isPalindromo=false;
                break;
            }
            System.out.println(tmp);
        }
        System.out.println("Palindromo "+isPalindromo);
    }
}
