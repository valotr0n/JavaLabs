package Task3;

public class Curve {

    private final int[] y;
    private final int colorType;

    public Curve(int width, int baseY, int amplitude, boolean isSin) {
        y = new int[width];

        for (int x = 0; x < width; x++) {
            double angle = x * 0.1;
            double value = isSin ? Math.sin(angle) : Math.cos(angle);
            y[x] = baseY - (int)(value * amplitude);
        }

        colorType = isSin ? 0 : 1;
    }

    public int size() {
        return y.length;
    }

    public int getY(int i) {
        return y[i];
    }

    public int getColorType() {
        return colorType;
    }
}
