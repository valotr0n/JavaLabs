import java.util.Scanner;

public class FindMaxNegative {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int rows = input.nextInt();
        int[][] array = new int[rows][];

        for (int i = 0; i < rows; i++) {
            System.out.print("Введите количество элементов в строке " + (i+1) + ": ");
            int cols = input.nextInt();
            array[i] = new int[cols];
            System.out.print("Введите " + cols + " чисел: ");
            for (int j = 0; j < cols; j++) {
                array[i][j] = input.nextInt();
            }
        }
        Integer maxNegative = null;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    if (maxNegative == null || array[i][j] > maxNegative) {
                        maxNegative = array[i][j];
                    }
                }
            }
        }    
        if (maxNegative != null) {
            System.out.println("Наибольший отрицательный элемент = " + maxNegative);
        } else {
            System.out.println("Отрицательных элементов нет.");
        }
        input.close();
    }
}