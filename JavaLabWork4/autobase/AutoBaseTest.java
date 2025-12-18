package lab4.autobase;

import lab4.car.*;

import java.util.Scanner;

public class AutoBaseTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutoBase base = new AutoBase(10);

        while (true) {
            System.out.println("\n=== Меню автобазы ===");
            System.out.println("1. Добавить машину");
            System.out.println("2. Отправить в рейс");
            System.out.println("3. Отправить в ремонт");
            System.out.println("4. Вернуть на базу");
            System.out.println("5. Показать машины на базе");
            System.out.println("6. Показать машины в рейсе");
            System.out.println("7. Показать машины в ремонте");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("Выберите тип (1 - легковой, 2 - грузовой, 3 - автобус, 4 - спец): ");
                    int type = Integer.parseInt(scanner.nextLine());

                    System.out.print("Марка: ");
                    String brand = scanner.nextLine();
                    System.out.print("Цвет: ");
                    String color = scanner.nextLine();
                    System.out.print("Кол-во колёс: ");
                    int wheels = Integer.parseInt(scanner.nextLine());

                    System.out.println("--- Двигатель ---");
                    System.out.print("Серийный номер: ");
                    String serial = scanner.nextLine();
                    System.out.print("Мощность: ");
                    int power = Integer.parseInt(scanner.nextLine());
                    System.out.print("Объём: ");
                    double volume = Double.parseDouble(scanner.nextLine());
                    System.out.print("Расход: ");
                    double consumption = Double.parseDouble(scanner.nextLine());
                    System.out.print("Тип топлива (PETROL, DIESEL, ELECTRIC, HYBRID): ");
                    Engine.FuelType fuelType = Engine.FuelType.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Цилиндры: ");
                    int cylinders = Integer.parseInt(scanner.nextLine());

                    Engine engine = new Engine(serial, power, volume, consumption, fuelType, cylinders);
                    Car car = null;

                    switch (type) {
                        case 1 -> car = new PassengerCar(brand, color, wheels, engine);
                        case 2 -> {
                            System.out.print("Грузоподъёмность: ");
                            double payload = Double.parseDouble(scanner.nextLine());
                            car = new Truck(brand, color, wheels, engine, payload);
                        }
                        case 3 -> {
                            System.out.print("Пассажировместимость: ");
                            int capacity = Integer.parseInt(scanner.nextLine());
                            car = new Bus(brand, color, wheels, engine, capacity);
                        }
                        case 4 -> {
                            System.out.print("Назначение: ");
                            String purpose = scanner.nextLine();
                            car = new SpecialCar(brand, color, wheels, engine, purpose);
                        }
                        default -> System.out.println("Неверный выбор типа машины");
                    }

                    if (car != null) {
                        System.out.print("Регистрационный знак: ");
                        String plate = scanner.nextLine();
                        try {
                            if (car instanceof SpecialCar special) {
                                special.setSpecialLicensePlate(plate);
                            } else {
                                car.setLicensePlate(plate);
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка номера: " + e.getMessage());
                        }
                        base.addCar(car);
                    }
                }

                case "2" -> {
                    Car car = selectCar(scanner, base);
                    if (car != null && !base.sendToRoute(car)) {
                        System.out.println("Нельзя отправить в рейс!");
                    }
                }

                case "3" -> {
                    Car car = selectCar(scanner, base);
                    if (car != null && !base.sendToRepair(car)) {
                        System.out.println("Нельзя отправить в ремонт!");
                    }
                }

                case "4" -> {
                    Car car = selectCar(scanner, base);
                    if (car != null && !base.returnToBase(car)) {
                        System.out.println("Нельзя вернуть на базу!");
                    }
                }

                case "5" -> base.showCarsOnBase();
                case "6" -> base.showCarsOnRoute();
                case "7" -> base.showCarsInRepair();
                case "0" -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный выбор!");
            }
        }
    }

    private static Car selectCar(Scanner scanner, AutoBase base) {
        System.out.println("Введите регистрационный номер автомобиля: ");
        String plate = scanner.nextLine();
        for (Car c : base.getCars()) {
            if (plate.equalsIgnoreCase(c.getLicensePlate())) {
                return c;
            }
        }
        System.out.println("Машина с таким номером не найдена.");
        return null;
    }
}
