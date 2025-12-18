public class Radar1 {
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
        double x = 20.0;
        double y = 25.0;
        double R = 40.0;
        double r = 15.0;
        double distance = CalculateDis(x,y);
        String status = Statuse(distance,R,r);
        System.out.println(status);
    }
    
}
