package module1.java_basic;

public class MountainBike extends Bike {
    protected int height;

    MountainBike(String brand) {
        super(brand);
        this.height = 0;
    }

    public void setHeight(int value) {
        this.height = value;
    }
}
