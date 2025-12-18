import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIndCyclePermutations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите подстроку :");
        String text = input.nextLine();
        List<String> permutations = new ArrayList<>();
        if (text != null && !text.isEmpty()) {
            int n = text.length();

            for (int i = 0; i < n; i++) {
                String permutation = text.substring(i) + text.substring(0,i);
                permutations.add(permutation);
            }
        }
        System.out.println("Перестановки строки " + text + ":");
        for (int i = 0; i < permutations.size(); i++) {
            System.out.println((i+1) + ". " + permutations.get(i));
        }
        input.close();
    }
}