package lab5.task09to10_hashtable;

public abstract class HashFunction<K> {
    private final int tableSize;

    protected HashFunction(int tableSize) {
        if (tableSize <= 0) {
            throw new IllegalArgumentException("Размер таблицы должен быть положительным");
        }
        this.tableSize = tableSize;
    }

    public final int index(K key) {
        int raw = Math.abs(hash(key));
        return raw % tableSize;
    }

    public final int tableSize() {
        return tableSize;
    }

    protected abstract int hash(K key);
}
