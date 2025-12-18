import java.util.Scanner;

public class NumberConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value;
        System.out.println("Введите целое десятичное число - ");
        value = input.nextInt();
        System.out.println("Исходное число - " + value);
        System.out.println("В двоичной системе - " + Integer.toBinaryString(value));
        System.out.println("В восьмеричной системе - " + Integer.toOctalString(value));
        System.out.println("В шестнадцатеричной системе - " + Integer.toHexString(value));
        input.close();
    }
}
