package module1.java_basic;

import org.openqa.selenium.InvalidArgumentException;

public class SimpleDog {
    private String name;
    private int age;
    private String color;
    private int energy;

    public SimpleDog(String name) {
        this(name, 1);
    }

    public SimpleDog(String name, int age) {
        this(name, age, "black");
    }

    public SimpleDog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.energy = 100;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0 && age >= 25) {
            throw  new InvalidArgumentException("Invalid age: " + age);
        } else {
            this.age = age;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void play() {
        if (this.energy <= 0) {
            System.out.println("[Play] - NO ENERGY");
        } else {
            this.energy -= 10;
            System.out.println("[Play] - Dog Energy: " + this.energy);
        }
    }

    public void sleep() {
        if (this.energy < 91) {
            this.energy += 10;
        }
        System.out.println("[Sleep] - Dog Energy: " + this.energy);
    }

    public int getEnergy() {
        return energy;
    }
}
