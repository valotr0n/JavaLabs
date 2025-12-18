package lab4.car;

public class PassengerCar extends Car {

    public PassengerCar(String brand, String color, int wheelCount, Engine engine) {
        super(brand, color, wheelCount, engine);
    }

    @Override
    public void printFullInfo() {
        System.out.println("=== Легковой автомобиль ===");
        printBaseInfo();
    }
}
