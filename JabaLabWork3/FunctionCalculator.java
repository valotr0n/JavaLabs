public class FunctionCalculator {
    public static void main(String[] args) {
        double start = Math.PI/15;
        double end  = Math.PI;
        double step = Math.PI/15;
        System.out.printf("%10s %15s %15s%n","x","sin(x)","e^x/(x*lg(x))");
        for (double x = start; x<=end; x+=step) {
            double sinX = Math.sin(x);
            double func = Math.exp(x)/(x*Math.log10(x));

            System.out.printf("%10.5f %15.7e %15.7e%n", x, sinX, func);
        }
    }
}