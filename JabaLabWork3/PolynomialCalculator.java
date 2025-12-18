public class PolynomialCalculator {

    public static double evaluateHorner(double[] coef, double x) {
        double value = coef[coef.length - 1];

        for (int i = coef.length - 2; i >= 0; i--) {
            value = value * x + coef[i];
        }

        return value;
    }

    public static double evaluateStandard(double[] coef, double x) {
        double sum = 0;

        for (int i = 0; i < coef.length; i++) {
            sum += coef[i] * Math.pow(x, i);
        }

        return sum;
    }

    public static void main(String[] args) {

        double[] p1 = {1, -5, 3, 2};
        double x1 = 2.0;

        double[] p2 = {1, -4, 6, -4, 1};
        double x2 = 3.0;

        testPolynomial(p1, x1, "2x**3 + 3x**2 - 5x + 1");
        testPolynomial(p2, x2, "x**4 - 4x**3 + 6x**2 - 4x + 1");
    }

    private static void testPolynomial(double[] poly, double x, String formula) {
        double h = evaluateHorner(poly, x);
        double s = evaluateStandard(poly, x);

        System.out.println("P(x) = " + formula + ", x = " + x);
        System.out.printf("Горнер: %.6f%n", h);
        System.out.printf("Обычный метод: %.6f%n", s);
        System.out.println("Совпадение: " +
                (Math.abs(h - s) < 1e-10 ? "Да" : "Нет"));
        System.out.println();
    }
}
