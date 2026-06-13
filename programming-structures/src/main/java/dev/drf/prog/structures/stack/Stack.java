package dev.drf.prog.structures.stack;

public interface Stack<T> {
    boolean isEmpty();

    boolean isNotEmpty();

    void push(T value);

    T pop();

    T peek();
}
