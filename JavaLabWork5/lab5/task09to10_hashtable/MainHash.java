package lab5.task09to10_hashtable;

import java.util.Arrays;
import java.util.List;

public class MainHash {
    public static void main(String[] args) {
        System.out.println("== Хэш-таблица с Person ==\n");

        int size = 20;
        HashFunction<String> hashFunction = new PersonHashFunction(size);
        HashTable<Person, String> table = new HashTable<>(size, hashFunction);

        List<Person> persons = Arrays.asList(
                new Person("Иванов", 30, "111-11-11"),
                new Person("Лобанов", 25, "222-22-22"),
                new Person("Балонов", 28, "333-33-33")
        );

        for (Person p : persons) {
            table.add(p);
        }

        System.out.println("Поиск Иванов: " + table.findFirst("Иванов").orElse(null));
        System.out.println("Поиск Петров: " + table.findFirst("Петров").orElse(null));
    }
}
