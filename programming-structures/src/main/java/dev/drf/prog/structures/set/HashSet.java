package dev.drf.prog.structures.set;

public interface HashSet<T> {
    boolean isEmpty();

    boolean isNotEmpty();

    int size();

    void put(T key);

    boolean contains(T key);

    boolean remove(T key);

    void clear();
}
