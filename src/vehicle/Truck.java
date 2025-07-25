package vehicle;

public class Truck extends Vehicle {
    public Truck(double maxSpeed, double cargoCapacity) {
        super(maxSpeed, cargoCapacity);
    }

    @Override
    public void deliver(String destination) {
        System.out.print("Грузовик загружен. ");
        super.deliver(destination);
    }
}
