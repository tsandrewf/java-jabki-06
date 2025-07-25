package vehicle;

public class Drone extends Vehicle {
    public Drone(double maxSpeed, double cargoCapacity) {
        super(maxSpeed, cargoCapacity);
    }

    @Override
    public void deliver(String destination) {
        System.out.print("Дрон взлетел. ");
        super.deliver(destination);
    }
}
