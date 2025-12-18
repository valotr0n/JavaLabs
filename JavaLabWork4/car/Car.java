package lab4.car;

import java.util.regex.Pattern;

public abstract class Car {
    public enum CarState {
        ON_BASE,
        ON_ROUTE,
        IN_REPAIR
    }

    public CarState state = CarState.ON_BASE;

    public CarState getState() {
        return state;
    }

    public void setState(CarState newState) {
        this.state = newState;
    }

    private final String brand;
    private final String color;
    private final int wheelCount;
    private String licensePlate;
    private final Engine engine;

    private static final String PLATE_PATTERN = "^[АВЕКМНОРСТУХ]\\s\\d{3}\\s[АВЕКМНОРСТУХ]{2}\\s\\d{2,3}\\sRUS$";
    Pattern platePattern = Pattern.compile(PLATE_PATTERN);

    public Car(String brand, String color, int wheelCount, Engine engine) {
        this.brand = brand;
        this.color = color;
        this.wheelCount = wheelCount;
        this.engine = engine;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getWheelCount() {
        return wheelCount;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public final void setLicensePlate(String plate) {
        if (plate == null || platePattern.matcher(plate).matches()) {
            this.licensePlate = plate;
        } else {
            throw new IllegalArgumentException("Неверный формат регистрационного номера!");
        }
    }

    public final void printBaseInfo() {
        System.out.println("Марка: " + brand);
        System.out.println("Цвет: " + color);
        System.out.println("Кол-во колес: " + wheelCount);
        System.out.println("Регистрационный знак: " + (licensePlate == null ? "Не задан" : licensePlate));
        engine.printInfo();
    }

    public abstract void printFullInfo();
}