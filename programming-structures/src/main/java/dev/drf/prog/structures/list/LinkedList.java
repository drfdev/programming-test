package dev.drf.prog.structures.list;

import java.util.function.Consumer;

public interface LinkedList<T> extends Iterable<T> {
    int len();

    boolean isEmpty();

    boolean isNotEmpty();

    T get(int index);

    void add(T value);

    T set(int index, T value);

    T remove(int index);

    T getFirst();

    T getLast();

    T setFirst(T value);

    T setLast(T value);

    void addFirst(T value);

    void addLast(T value);
}
