package module1.java_basic;
import java.util.*;

public class balanceo {
    public static void main(String[] args) {
        String cadena = "[({()})]";
        // <Char> letras = new Stack<>();
        Stack<Character> letra = new Stack<>();
        Boolean flag = false;

        char[] ch = new char[cadena.length()];

        for(int i=0; i <= cadena.length()-1; i++)
        {
            ch[i] = cadena.charAt(i);

            if(ch[i] == '('){
                letra.push('(');
            }else if(ch[i] == ')'){
                if(letra.peek() == '(') {
                    if (!letra.empty()) {
                        letra.pop();
                        flag = true;
                    }
                }else{
                    flag = false;
                    break;}

            } else if(ch[i] == '['){
                letra.push('[');
            }else if(ch[i] == ']'){
                if(letra.peek() == '[') {
                    //if (!letra.empty()) {
                        letra.pop();
                    //}
                }

            }else if(ch[i] == '{'){
                letra.push('{');
            }else if(ch[i] == '}'){
                if(letra.peek() == '{') {
                    if (!letra.empty()) {
                        letra.pop();
                    }
                }
            }

            //System.out.println(ch[i]);
        }
        if(letra.empty()){
            System.out.println("Es correcto "+ cadena);
        }else{
            System.out.println("No es correcto "+ cadena );
        }

    }
}
