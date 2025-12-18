import java.util.Scanner;

enum CircleRelation {
    COINCIDENT, TOUCH_EXTERNAL, INTERSECT, SEPARATE, FIRST_IN_SECOND, SECOND_IN_FIRST, TOUCH_INTERNAL
}

public class CircleRelationChecker {
    public static CircleRelation checkCircles(double x1, double y1, double r1, double x2, double y2, double r2) {
        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        if (d == 0 && r1 == r2) return CircleRelation.COINCIDENT;//совпадают
        if (d == r1 + r2) return CircleRelation.TOUCH_EXTERNAL;//касаются внешне 
        if (d < r1 + r2 && d > Math.abs(r1 - r2)) return CircleRelation.INTERSECT;//пересекаются в двух точках
        if (d > r1 + r2) return CircleRelation.SEPARATE;//разделены
        if (d == Math.abs(r1 - r2)) return CircleRelation.TOUCH_INTERNAL;//касаются внутренне
        if (d < Math.abs(r1 - r2) && r1 > r2) return CircleRelation.SECOND_IN_FIRST;//вторая внутри первой
        return CircleRelation.FIRST_IN_SECOND;//первая внутри второй 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите x1, y1, r1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double r1 = input.nextDouble();
        System.out.println("Введите x2, y2, r2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double r2 = input.nextDouble();

        CircleRelation result = checkCircles(x1, y1, r1, x2, y2, r2);
        System.out.println("Результат: " + result);
        input.close();
    }
}
