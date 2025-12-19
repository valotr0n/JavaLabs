package Task2;

public class Curve {

    private double[] x;
    private double[] y;

    public void setData(double from, double to, int n) {
        x = new double[n];
        y = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = from + (to - from) * i / (n - 1);
            y[i] = Math.sin(x[i]);
        }
    }

    public int size() {
        return x.length;
    }

    public double getX(int i) {
        return x[i];
    }

    public double getY(int i) {
        return y[i];
    }
}
