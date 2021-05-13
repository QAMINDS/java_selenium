package module1.java_basic;

public class FizzBuzz {
    public static void main(String[] args){
        float rest3, rest5;

        for (int i =1; i<=100; i++){
            rest3=i%3;
            rest5=i%5;
            if(rest3 == 0 && rest5 == 0 ){
                System.out.println("FizzBuzz");
            }else if(rest5 == 0){
                System.out.println("Buzz");
            }else if(rest3 == 0){
                System.out.println("Fizz");
            }else{
                System.out.println(i);
            }

            //
        }
    }
}
