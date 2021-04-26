package module1.java_basic;

public class Truck implements IVehicle {
    protected int speed;
    Truck() {
        this.speed = 0;
    }

    public void speedUp() {
        this.speed += 1;
        System.out.println(String.format("Truck new speed %s", this.speed));
    }

    public static void main(String[] args) {
        IVehicle vehicle = new Truck();
        vehicle.speedUp();
        vehicle.speedUp();

        vehicle = new Tank();
        vehicle.speedUp();
        vehicle.speedUp();
    }
}
