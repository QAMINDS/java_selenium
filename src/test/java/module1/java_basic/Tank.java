package module1.java_basic;

public class Tank implements IVehicle, IWeapon{
    protected int speed;
    Tank() {
        this.speed = 0;
    }

    public void speedUp() {
        System.out.println(String.format("Tank speed %s", this.speed));
    }

    public static void main(String[] args)  {
        Tank tank = new Tank();
        tank.speedUp();
    }
}
