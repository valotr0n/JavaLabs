package lab4.car;

public final class Bus extends Car {
    private int passengerCapacity;

    public Bus(String brand, String color, int wheelCount, Engine engine, int passengerCapacity) {
        super(brand, color, wheelCount, engine);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public void printFullInfo() {
        System.out.println("=== Автобус ===");
        printBaseInfo();
        System.out.println("Вместимость: " + passengerCapacity);
    }
}
