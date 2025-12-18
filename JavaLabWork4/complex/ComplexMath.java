package lab4.complex;

public class ComplexMath {

    public static Complex exp(Complex x) {
        double expReal = Math.exp(x.getReal());
        return new Complex(
            expReal * Math.cos(x.getImag()),
            expReal * Math.sin(x.getImag())
        );
    }

    public static Complex sin(Complex x) {
        return new Complex(
            Math.sin(x.getReal()) * Math.cosh(x.getImag()),
            Math.cos(x.getReal()) * Math.sinh(x.getImag())
        );
    }

    public static Complex cos(Complex x) {
        return new Complex(
            Math.cos(x.getReal()) * Math.cosh(x.getImag()),
            -Math.sin(x.getReal()) * Math.sinh(x.getImag())
        );
    }
}