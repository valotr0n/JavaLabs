package lab4.graphics;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final Axis xAxis;
    private final Axis yAxis;
    private final Grid grid;
    private final List<Label> labels;
    private final List<Curve> curves;

    public Graph(Axis xAxis, Axis yAxis, Grid grid) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.grid = grid;
        this.labels = new ArrayList<>();
        this.curves = new ArrayList<>();
    }

    public void addLabel(Label label) {
        labels.add(label);
    }

    public void addCurve(Curve curve) {
        curves.add(curve);
    }

    public Axis getXAxis() {
        return xAxis;
    }

    public Axis getYAxis() {
        return yAxis;
    }

    public Grid getGrid() {
        return grid;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public List<Curve> getCurves() {
        return curves;
    }

    public void printGraphInfo() {
        System.out.println("=== Параметры графика ===");
        xAxis.printInfo();
        yAxis.printInfo();
        grid.printInfo();

        System.out.println("\nМетки:");
        if (labels.isEmpty()) System.out.println("(нет)");
        else labels.forEach(Label::printInfo);

        System.out.println("\nКривые:");
        if (curves.isEmpty()) System.out.println("(нет)");
        else curves.forEach(Curve::printInfo);
    }
}
