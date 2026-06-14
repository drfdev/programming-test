package dev.drf.prog.structures.deque;

public interface Deque<T> {
    boolean isEmpty();

    boolean isNotEmpty();

    void addFirst(T value);

    T popFirst();

    T peekFirst();

    void addLast(T value);

    T popLast();

    T peekLast();
}
