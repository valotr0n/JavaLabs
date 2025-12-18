package lab4.car;

public class SpecialCar extends Car {
    private final String purpose;

    public SpecialCar(String brand, String color, int wheelCount, Engine engine, String purpose) {
        super(brand, color, wheelCount, engine);
        this.purpose = purpose;
    }

    public String getPurpose() {
        return purpose;
    }

    @Override
    public void printFullInfo() {
        System.out.println("=== Специальный автомобиль ===");
        printBaseInfo();
        System.out.println("Назначение: " + purpose);
    }
    public void setSpecialLicensePlate(String plate) {
        if (plate != null && plate.startsWith("СП")) {
            super.setLicensePlate(plate);
        } else {
            throw new IllegalArgumentException("Неверный формат номера для специального автомобиля (ожидается СП...)!");
        }
    }
}
