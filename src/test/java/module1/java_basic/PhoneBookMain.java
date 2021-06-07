package module1.java_basic;

import java.util.Map;

public class PhoneBookMain {
    public static void main(String[] args) {

        PhoneBook book = new PhoneBook();

        book.insert(123, "Jesus");
        book.insert(456, "Susana");
        book.insert(789, "Christina");
        book.insert(111, "Pedro");

        book.lookUp(123);

        book.delete(111);

        book.updateName(123, "Ruben");

        book.mostrarDirectorio();

    }
}
