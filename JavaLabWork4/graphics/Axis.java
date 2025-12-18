package lab4.graphics;

public class Axis {
    private final String name;
    private final double min;
    private final double max;
    private final double step;

    public Axis(String name, double min, double max, double step) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getStep() {
        return step;
    }

    public void printInfo() {
        System.out.printf("Ось %s: от %.2f до %.2f с шагом %.2f\n", name, min, max, step);
    }
} 