package lab5.task07to08;

public class MainCoinChange {
    public static void main(String[] args) {
        System.out.println("== Размен суммы монетами ==\n");

        int[] coins = {1, 2, 3};
        int amount = 5;
        DList<Integer, Integer> table = CoinChangeSolver.buildTable(amount, coins);

        for (int i = 0; i < table.size(); i++) {
            System.out.println("Сумма " + table.getFirst(i) + " -> " + table.getSecond(i));
        }
    }
}
