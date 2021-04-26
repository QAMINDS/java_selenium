package module1.java_basic;

public class RoadBike extends Bike {
    RoadBike(String brand) {
        super(brand);
    }

    @Override
    protected void speedUp() {
        this.speed += 2;
        System.out.println(String.format("%s speed %s", this.brand, this.speed));
    }

    public static void main(String[] args) {
        RoadBike roadBike = new RoadBike("Road Bike");
        roadBike.speedUp();

        Bike bike = new Bike("Simple Bike");
        bike.speedUp();
    }
}
