package dev.drf.prog.structures.array;

public interface Array<T> {
    int len();

    boolean isEmpty();

    boolean isNotEmpty();

    T get(int index);

    void add(T value);

    void addByIndex(int index, T value);

    T set(int index, T value);

    T remove(int index);

    T getFirst();

    T getLast();

    T setFirst(T value);

    T setLast(T value);

    void addFirst(T value);

    void addLast(T value);
}
