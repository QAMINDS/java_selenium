package module1.java_basic;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args){
        System.out.println("Hello QA Minds");
        int var = 250;

        List list = new ArrayList<String>();
        list.add('A');
        list.add('B');
        magicMethod(list);
        System.out.println(list.toString());
    }

    public static void magicMethod(List list) {
        list.remove(0);
        list.add('C');
    }
}
