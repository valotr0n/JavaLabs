import java.util.Scanner;


public class Radar2 {
    public static double CalculateDis(double x, double y) {
        return Math.sqrt(x*x+y*y);
    }
    public static String Statuse(double distance, double R, double r) {
        if (distance < R) {
            return "Не обнаружен";
        } else if (distance > r && distance <= R) {
            return "Обнаружен";
        } else {
            return "Тревога";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координату x : ");
        double x = scanner.nextDouble();
        System.out.println("Введите координату y : ");
        double y = scanner.nextDouble();
        System.out.println("Введите R : ");
        double R = scanner.nextDouble();
        System.out.println("Введите r : ");
        double r = scanner.nextDouble();
        double distance = CalculateDis(x,y);
        String status = Statuse(distance,R,r);
        System.out.println(status);
        scanner.close();
    }
    
}
