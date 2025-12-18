package lab4.graphics;

import java.util.List;

public class Curve {
    private final String name;
    private final String color;
    private final List<Double> xValues;
    private final List<Double> yValues;

    public Curve(String name, String color, List<Double> xValues, List<Double> yValues) {
        this.name = name;
        this.color = color;
        this.xValues = xValues;
        this.yValues = yValues;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<Double> getXValues() {
        return xValues;
    }

    public List<Double> getYValues() {
        return yValues;
    }

    public void printInfo() {
        System.out.printf("Кривая '%s', цвет: %s, %d точек\n", name, color, xValues.size());
    }
}