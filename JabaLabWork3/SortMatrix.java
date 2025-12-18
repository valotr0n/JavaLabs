import java.util.Arrays;
import java.util.Scanner;

public class SortMatrix {
    public static void PrintArray(int[][] array) {
        for (int[] row: array) {
            System.out.println(Arrays.toString(row));
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] array = new int[3][3];
        System.out.println("Введите 9 числе для массива : ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = input.nextInt();
            }
        }
        System.out.println("До сортировки: ");
        PrintArray(array);

        for (int i = 0; i < 3; i++) {
            Arrays.sort(array[i]);
        }
        System.out.println("\nПосле сортировки : ");
        PrintArray(array);
        input.close();
    }
}
