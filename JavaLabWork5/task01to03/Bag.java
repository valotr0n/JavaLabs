package lab5.task01to03;

import java.util.Random;

public class Bag {
    private final Object[] data;
    private int size = 0;
    private final Random random = new Random();

    public Bag(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Размер мешка должен быть положительным");
        }
        this.data = new Object[capacity];
    }

    public void add(Object value) {
        if (size == data.length) {
            throw new IllegalStateException("Мешок заполнен");
        }
        int insertIndex = random.nextInt(size + 1);
        data[size] = value;
        if (insertIndex != size) {
            Object tmp = data[insertIndex];
            data[insertIndex] = data[size];
            data[size] = tmp;
        }
        size++;
    }

    public Object remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Мешок пуст");
        }
        int index = random.nextInt(size);
        Object value = data[index];
        data[index] = data[size - 1];
        data[size - 1] = null;
        size--;
        return value;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Мешок пуст");
        }
        return data[random.nextInt(size)];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}