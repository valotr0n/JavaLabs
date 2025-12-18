package lab5.task09to10_hashtable;

public interface Keyed<K> {
    K key();

    default boolean matches(K value) {
        return key().equals(value);
    }
}