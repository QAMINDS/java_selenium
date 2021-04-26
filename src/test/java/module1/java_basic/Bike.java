package module1.java_basic;

public class Bike {
    protected String brand;
    protected int speed;

    Bike(String brand) {
        this.brand = brand;
        this.speed = 0;
    }

    protected void speedUp() {
        this.speed += 1;
        System.out.println(String.format("%s speed %s", this.brand, this.speed));
    }
}
