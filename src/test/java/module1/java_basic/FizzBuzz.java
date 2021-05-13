package module1.java_basic;

public class FizzBuzz {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {
            int a = i % 3;
            int b = i % 5;

            if (a == 0 && b ==0) {
                System.out.println("FizzBuzz");
            }
                else if (a == 0) {
                System.out.println("Fizz");
            }
                else if (b == 0) {
                    System.out.println("Buzz");
                }
                else {
                System.out.println(i);
            }
            }

        }
    }

