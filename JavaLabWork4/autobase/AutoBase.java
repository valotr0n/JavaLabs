package lab4.autobase;

import lab4.car.Car;
import java.util.ArrayList;
import java.util.List;

public class AutoBase {
    private final List<Car> cars;
    private final int capacity;

    public AutoBase(int capacity) {
        this.capacity = capacity;
        this.cars = new ArrayList<>();
    }

    public boolean addCar(Car car) {
        if (cars.size() >= capacity) {
            System.out.println("Автобаза переполнена!");
            return false;
        }
        cars.add(car);
        return true;
    }

    public boolean removeCar(Car car) {
        return cars.remove(car);
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }


    public boolean sendToRoute(Car car) {
        if (cars.contains(car) && car.getState() == Car.CarState.ON_BASE) {
            car.setState(Car.CarState.ON_ROUTE);
            return true;
        }
        return false;
    }

    public boolean sendToRepair(Car car) {
        if (cars.contains(car) && car.getState() != Car.CarState.IN_REPAIR) {
            car.setState(Car.CarState.IN_REPAIR);
            return true;
        }
        return false;
    }

    public boolean returnToBase(Car car) {
        if (cars.contains(car) && car.getState() != Car.CarState.ON_BASE) {
            car.setState(Car.CarState.ON_BASE);
            return true;
        }
        return false;
    }

    public void showCarsOnBase() {
        System.out.println("=== Машины на базе ===");
        cars.stream()
            .filter(c -> c.getState() == Car.CarState.ON_BASE)
            .forEach(Car::printFullInfo);
    }

    // second cycle 
    // public void showCarsOnBase {
    //     for (int i = 0; i < cars.size(); i++) {
    //         Car c = cars.get(i);
    //         if (c.getState() == Car.CarState.ON_BASE) {
    //             c.printFullInfo();
    //         }
    //     }
    // }
    public void showCarsOnRoute() {
        System.out.println("=== Машины в рейсе ===");
        cars.stream()
            .filter(c -> c.getState() == Car.CarState.ON_ROUTE)
            .forEach(Car::printFullInfo);
    }

    public void showCarsInRepair() {
        System.out.println("=== Машины в ремонте ===");
        cars.stream()
            .filter(c -> c.getState() == Car.CarState.IN_REPAIR)
            .forEach(Car::printFullInfo);
    }
}