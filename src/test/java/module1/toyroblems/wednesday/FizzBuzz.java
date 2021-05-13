package module1.toyroblems.wednesday;

public class FizzBuzz {

    public static void main(String[] args){
        System.out.println("Hello QA Minds");

        for (int k = 1; k < 100; k++) {

            if (((k%3) == 0) && ((k%5) == 0)) {
                System.out.println("FizzBuzz");
            } else if ((k%5) == 0) {
                System.out.println("Buzz");
            } else  if ((k%3) == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(k);
            }
        }
    }
}
