package lab4.car;

public class Truck extends Car {
    private double payloadCapacity; 

    public Truck(String brand, String color, int wheelCount, Engine engine, double payloadCapacity) {
        super(brand, color, wheelCount, engine);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
    }

    @Override
    public void printFullInfo() {
        System.out.println("=== Грузовой автомобиль ===");
        printBaseInfo();
        System.out.println("Грузоподъёмность: " + payloadCapacity + " т");
    }
}
