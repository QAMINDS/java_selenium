package module1.java_basic;

import java.util.Stack;

public class Balanceo {
    public static void main(String[] args) {

        // /*valido*/ String input = "[()]{}{[()()]()}";
        // /*caracteres inválidos*/ String input = "[(a)]{}{[f()()]99()}";
        // /*caracteres de cierre sin apertura*/ String input = "}[()]{}){[()()]()}]";
        // /*caracteres de apertura al final, sin cierre*/ String input = "[()]{}{[()()]()}({[";
         /*caracteres de apertura intercalados, sin cierre*/ String input = "[()]({}{[()[()]({)}";


        String allowed = "{[()]}";
        String opens = "{[(";
        String closes = ")]}";
        char[] c = input.toCharArray();
        Stack<Character> invalids = new Stack<>();
        Stack<Integer> invalidsPtn = new Stack<>();
        Stack<Character> openers = new Stack<>();
        Stack<Integer> openersPtn = new Stack<>();
        boolean isValid = true;

        for (int i = 0; i <= c.length - 1; i++) {
            if (allowed.indexOf(c[i]) == -1) {
                invalids.push(c[i]);
                invalidsPtn.push(i + 1);
            } else if (opens.indexOf(c[i]) != -1) {
                openers.push(c[i]);
                openersPtn.push(i + 1);
            }
            if (openers.empty() && closes.indexOf(c[i]) != -1) {
                System.out.println("Secuencia inválida. Revise el caracter " + c[i] + " en la posicion " + (i + 1));
                isValid = false;
                break;
            } else if (!openers.empty() && closes.indexOf(c[i]) != -1) {
                if (openers.peek() == '(' && c[i] == ')') {
                    openers.pop();
                    openersPtn.pop();
                } else if (openers.peek() == '[' && c[i] == ']') {
                    openers.pop();
                    openersPtn.pop();
                } else if (openers.peek() == '{' && c[i] == '}') {
                    openers.pop();
                    openersPtn.pop();
                } else {
                    System.out.println("Caracteres de apertura sin correspondiente caracter de cierre : " + openers);
                    System.out.println("Revise las posiciones: " + openersPtn);
                    isValid = false;
                    break;
                }
            }
        }
        if (!invalids.empty()) {
            System.out.println("Caracteres inválidos: " + invalids + ". Corrija las posiciones: " + invalidsPtn);
        } else if (!openers.empty() && isValid == true) {
            System.out.println("Caracteres de apertura sin correspondiente caracter de cierre : " + openers);
            System.out.println("Revise las posiciones: " + openersPtn);
        } else if (isValid == true) {
            System.out.println("Secuencia válida");
        }
    }
}
