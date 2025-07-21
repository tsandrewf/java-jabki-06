package vehicle;

public class Vehicle {
    private double maxSpeed;
    private double cargoCapacity;

    public Vehicle(double maxSpeed, double cargoCapacity) {
        this.maxSpeed = maxSpeed;
        this.cargoCapacity = cargoCapacity;
    }

    public void deliver(String destination) {
        System.out.printf("Доставка в %s\n", destination);
    }
}
