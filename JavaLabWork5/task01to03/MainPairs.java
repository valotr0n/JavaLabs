package lab5.task01to03;

public class MainPairs {
    public static void main(String[] args) {
        System.out.println("== Демонстрация Pair, Bag и PairBag ==\n");

        // Pair
        Pair<Integer, String> pair = Pair.makePair(1, "один");
        System.out.println("Пара: " + pair);

        // Bag
        Bag bag = new Bag(4);
        bag.add(123);
        bag.add("строка");
        bag.add(pair);
        System.out.println("Случайный элемент из мешка: " + bag.peek());
        System.out.println("Извлекли: " + bag.remove());
        System.out.println("Текущий размер: " + bag.size());

        // PairBag
        PairBag pairBag = new PairBag(3);
        pairBag.addPair(Pair.makePair("a", 10));
        pairBag.addPair(Pair.makePair(2, 3));
        System.out.println("PairBag достал: " + pairBag.removePair());
    }
}
