package module1.java_basic;

public class Tank implements IVehicle{
    protected int speed;
    Tank() {
        this.speed = 0;
    }

    public void speedUp() {
        this.speed += 1;
        System.out.println(String.format("Tank speed %s", this.speed));
    }
}
