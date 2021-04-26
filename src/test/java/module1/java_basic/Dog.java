package module1.java_basic;

public class Dog {
    private String name;
    private int age;
    private int position;

    Dog(String name, int age) {
        this.name = name;
        this.age = age;
        this.position = 0;
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
        this.age = age;
    }

    public int getPosition() {return position;}

    public void run(int distance) {
        this.position += distance;
    }

    public String toString() {
        return String.format("%s has %d years, position: %d", this.name, this.age, this.position);
    }

    public static void main(String[] args){
       Dog dog = new Dog("Rex", 1);
       dog.run(10);
       assert dog.getPosition() == 10;
       System.out.println(dog.toString());
       modifyDog(dog);
        System.out.println(String.format("ID outside modify method: %d", System.identityHashCode(dog)));
    }

    public static void modifyDog(Dog dog) {
        System.out.println(String.format("ID before new assignment: %d", System.identityHashCode(dog)));
        dog = new Dog("Max", 5);
        assert dog.getName() == "Max";
        System.out.println(String.format("ID after new assignment: %d", System.identityHashCode(dog)));
    }
}
