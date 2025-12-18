package lab4.graphics;

public class Grid {
    private final boolean visible;
    private final double spacing;

    public Grid(boolean visible, double spacing) {
        this.visible = visible;
        this.spacing = spacing;
    }

    public boolean isVisible() {
        return visible;
    }

    public double getSpacing() {
        return spacing;
    }

    public void printInfo() {
        if (visible) {
            System.out.printf("Сетка включена, шаг: %.2f\n", spacing);
        } else {
            System.out.println("Сетка отключена");
        }
    }
}
