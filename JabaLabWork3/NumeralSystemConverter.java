public class NumeralSystemConverter {

    public static String convert(int number, int base) {
        if (number == 0) {
            return "0";
        }

        boolean negative = number < 0;
        number = Math.abs(number);

        StringBuilder result = new StringBuilder();

        while (number > 0) {
            int digit = number % base;
            result.append(digit);
            number /= base;
        }

        if (negative) {
            result.append("-");
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        int[] numbers = {0, 12, 255, -15, 100};
        int[] bases = {2, 3, 5, 8};

        for (int n : numbers) {
            for (int b : bases) {
                String my = convert(n, b);
                String javaVersion = Integer.toString(n, b);

                System.out.println("Число: " + n);
                System.out.println("Основание: " + b);
                System.out.println("Мой результат: " + my);
                System.out.println("Java результат: " + javaVersion);
                System.out.println("Совпадает: " + my.equals(javaVersion));
                System.out.println();
            }
        }
    }
}
