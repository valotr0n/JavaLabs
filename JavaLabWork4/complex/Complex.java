package lab4.complex;

public class Complex {
    private final double real;
    private final double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imag + other.imag);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imag - other.imag);
    }

    public Complex multiply(Complex other) {
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new Complex(r, i);
    }

    public Complex divide(Complex other) {
        double denom = other.real * other.real + other.imag * other.imag;
        if (denom == 0) {
            throw new ArithmeticException("Деление на ноль в комплексном числе");
        }
        double r = (this.real * other.real + this.imag * other.imag) / denom;
        double i = (this.imag * other.real - this.real * other.imag) / denom;
        return new Complex(r, i);
    }

    public double modulus() {
        return Math.hypot(real, imag);
    }

    @Override
    public String toString() {
        if (imag >= 0) {
            return String.format("%.2f + %.2fi", real, imag);
        } else {
            return String.format("%.2f - %.2fi", real, -imag);
        }
    }
}