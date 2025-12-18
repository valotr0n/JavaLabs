package lab5.task04to05;

import lab5.task01to03.Pair;

public class MainPairContainers {
    public static void main(String[] args) {
        System.out.println("== Демонстрация GPairBag и GenericPairBag ==\n");

        // GPairBag
        GPairBag<String, Integer> gPairBag = new GPairBag<>(3);
        gPairBag.add(Pair.makePair("x", 5));
        gPairBag.add(Pair.makePair("y", 6));
        System.out.println("GPairBag просмотр: " + gPairBag.peek());

        // GenericPairBag
        GenericPairBag<String, String> genericPairBag = new GenericPairBag<>();
        genericPairBag.add(Pair.makePair("left", "right"));
        genericPairBag.add(Pair.makePair("hello", "world"));
        System.out.println("GenericPairBag достал: " + genericPairBag.remove());
    }
}
