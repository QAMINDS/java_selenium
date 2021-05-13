package module1.java_basic;
import java.util.Scanner;

public class Palindromo {

    public static boolean Palindromot(String Palabra) //true o false
    {
        for(int i = 0; i < Palabra.length(); i++)
        {
            if (Palabra.charAt(i) != Palabra.charAt(Palabra.length() - i - 1))//comparar la primer letra con la ultima lectra
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String Palabra;
        Scanner Tipo = new Scanner(System.in);
        System.out.print("ingrese una palabra: ");
        Palabra = Tipo.next();

        if (Palindromot(Palabra) == true)
        {
            System.out.printf("La palabra \"%s\" es un palindromo%n", Palabra);
        } else
        {
            System.out.printf("La palabra \"%s\" no es un palindromo%n", Palabra);
        }

    }
}
