public class NumericalIntegration {

    public static double integrateLeftRectangles(double a, double b, int n) {
        double step = (b - a) / (n - 1);
        double sum = 0.0;

        for (int i = 0; i < n - 1; i++) {
            double x = a + i * step;
            sum += function(x) * step;
        }

        return sum;
    }

    public static double function(double x) {
        return Math.exp(x) - Math.pow(x, 3);
    }

    public static double exactIntegral(double a, double b) {
        return (Math.exp(b) - Math.pow(b, 4) / 4.0)
             - (Math.exp(a) - Math.pow(a, 4) / 4.0);
    }

    public static void main(String[] args) {
        double a = 0.0;
        double b = 4.0;
        int points = 101;

        double numeric = integrateLeftRectangles(a, b, points);
        double exact = exactIntegral(a, b);

        double absError = Math.abs(numeric - exact);
        double relError = absError / Math.abs(exact) * 100;

        System.out.printf("Интервал: [%.1f, %.1f]%n", a, b);
        System.out.printf("Число точек: %d%n", points);
        System.out.printf("Численный интеграл: %.6f%n", numeric);
        System.out.printf("Точный интеграл: %.6f%n", exact);
        System.out.printf("Абсолютная погрешность: %.6f%n", absError);
        System.out.printf("Относительная погрешность: %.4f%%%n", relError);
    }
}
