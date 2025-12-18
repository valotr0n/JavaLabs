package lab4.graphics;

import java.awt.*;
import java.util.List;

public class GraphCanvas extends Canvas {

    private final Graph graph;

    public GraphCanvas(Graph graph) {
        this.graph = graph;
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {

        int w = getWidth();
        int h = getHeight();

        Axis x = graph.getXAxis();
        Axis y = graph.getYAxis();

        double xScale = w / (x.getMax() - x.getMin());
        double yScale = h / (y.getMax() - y.getMin());

        int xZero = toScreenX(0, x, xScale);
        int yZero = toScreenY(0, y, yScale);

        drawAxes(g, w, h, xZero, yZero);
        drawGrid(g, w, h, x, y, xScale, yScale);
        drawCurves(g, x, y, xScale, yScale);
    }

    private int toScreenX(double xVal, Axis x, double scale) {
        return (int)((xVal - x.getMin()) * scale);
    }

    private int toScreenY(double yVal, Axis y, double scale) {
        return (int)((y.getMax() - yVal) * scale);
    }

    private void drawAxes(Graphics g, int w, int h, int xZero, int yZero) {
        g.setColor(Color.BLACK);
        g.drawLine(0, yZero, w, yZero);
        g.drawLine(xZero, 0, xZero, h);
    }

    private void drawGrid(Graphics g, int w, int h, Axis x, Axis y, double xs, double ys) {
        if (!graph.getGrid().isVisible()) return;

        g.setColor(Color.LIGHT_GRAY);
        double step = graph.getGrid().getSpacing();

        for (double xVal = x.getMin(); xVal <= x.getMax(); xVal += step) {
            int xPos = toScreenX(xVal, x, xs);
            g.drawLine(xPos, 0, xPos, h);
        }

        for (double yVal = y.getMin(); yVal <= y.getMax(); yVal += step) {
            int yPos = toScreenY(yVal, y, ys);
            g.drawLine(0, yPos, w, yPos);
        }
    }

    private void drawCurves(Graphics g, Axis x, Axis y, double xs, double ys) {
        for (Curve c : graph.getCurves()) {

            g.setColor(stringToColor(c.getColor()));

            List<Double> xv = c.getXValues();
            List<Double> yv = c.getYValues();

            for (int i = 0; i < xv.size() - 1; i++) {
                int x1 = toScreenX(xv.get(i), x, xs);
                int y1 = toScreenY(yv.get(i), y, ys);
                int x2 = toScreenX(xv.get(i + 1), x, xs);
                int y2 = toScreenY(yv.get(i + 1), y, ys);
                g.drawLine(x1, y1, x2, y2);
            }
        }
    }

    private Color stringToColor(String name) {
        return switch (name.toLowerCase()) {
            case "red" -> Color.RED;
            case "green" -> Color.GREEN;
            case "blue" -> Color.BLUE;
            case "yellow" -> Color.YELLOW;
            case "black" -> Color.BLACK;
            case "gray", "grey" -> Color.GRAY;
            case "magenta" -> Color.MAGENTA;
            default -> Color.BLACK;
        };
    }
}
