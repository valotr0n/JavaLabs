package lab4.graphics;

public class Label {
    private final String text;
    private final double x;
    private final double y;

    public Label(String text, double x, double y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }

    public String getText() {
        return text;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void printInfo() {
        System.out.printf("Метка '%s' на координатах (%.2f, %.2f)\n", text, x, y);
    }
}