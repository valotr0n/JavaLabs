package lab4.car;

public class Engine {
    private final String serialNumber;
    private int horsepower;
    private double volume;
    private double fuelConsumption;
    private FuelType fuelType;
    private int cylinderCount;

    public enum FuelType {
        PETROL, DIESEL, ELECTRIC, HYBRID
    }

    public Engine(String serialNumber, int horsepower, double volume, double fuelConsumption, FuelType fuelType, int cylinderCount) {
        this.serialNumber = serialNumber;
        this.horsepower = horsepower;
        this.volume = volume;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
        this.cylinderCount = cylinderCount;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public int getCylinderCount() {
        return cylinderCount;
    }

    public void setCylinderCount(int cylinderCount) {
        this.cylinderCount = cylinderCount;
    }

    public void printInfo() {
        System.out.println("Двигатель:");
        System.out.println("  Серийный номер: " + serialNumber);
        System.out.println("  Мощность: " + horsepower + " л.с.");
        System.out.println("  Объем: " + volume + " л");
        System.out.println("  Расход топлива: " + fuelConsumption + " л/100км");
        System.out.println("  Тип топлива: " + fuelType);
        System.out.println("  Кол-во цилиндров: " + cylinderCount);
    }
}
