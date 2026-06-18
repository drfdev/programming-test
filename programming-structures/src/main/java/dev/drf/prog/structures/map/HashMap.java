package dev.drf.prog.structures.map;

public interface HashMap<K, V> {
    boolean isEmpty();

    boolean isNotEmpty();

    int size();

    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

    V remove(K key);

    void clear();
}
