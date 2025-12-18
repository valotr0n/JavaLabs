package lab4.complex;
import java.util.Scanner;

public class ComplexTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите первое действительное и первое мнимое число");
        int real1 = input.nextInt(), imag1 = input.nextInt();
        Complex a = new Complex(real1, imag1);
        System.out.println("Введите второе действительное и первое мнимое число");
        int real2 = input.nextInt(), imag2 = input.nextInt();
        Complex b = new Complex(real2, imag2);

        System.out.println("Комплексные числа:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("\nАрифметические операции:");
        System.out.println("a + b = " + a.add(b));
        System.out.println("a - b = " + a.subtract(b));
        System.out.println("a * b = " + a.multiply(b));
        System.out.println("a / b = " + a.divide(b));

        System.out.println("\nМодули:");
        System.out.println("|a| = " + a.modulus());
        System.out.println("|b| = " + b.modulus());

        System.out.println("\nФункции:");
        System.out.println("exp(a) = " + ComplexMath.exp(a));
        System.out.println("sin(a) = " + ComplexMath.sin(a));
        System.out.println("cos(a) = " + ComplexMath.cos(a));
        input.close();
    }
}
