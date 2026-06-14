package dev.drf.prog.structures.queue;

public interface Queue<T> {
    boolean isEmpty();

    boolean isNotEmpty();

    void add(T value);

    T pop();

    T peek();
}
