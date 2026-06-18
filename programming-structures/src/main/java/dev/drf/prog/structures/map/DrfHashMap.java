package dev.drf.prog.structures.map;

import java.util.Arrays;
import java.util.Objects;

public final class DrfHashMap<K, V> implements HashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final float MIN_LOAD_FACTOR = 0.15f;
    private static final float MAX_LOAD_FACTOR = 1.0f;

    private static final int MIN_CAPACITY = 1;
    private static final int MAX_CAPACITY = 1 << 20;

    private int capacity;
    private final float loadFactor;

    private int size;
    private MapBucket<K, V>[] buckets;

    public DrfHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public DrfHashMap(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public DrfHashMap(int capacity, float loadFactor) {
        this.capacity = calculateCapacity(capacity);
        this.loadFactor = calculateLoadFactor(loadFactor);
        this.size = 0;
        this.buckets = new MapBucket[this.capacity];
    }

    private int calculateCapacity(int capacity) {
        if (capacity < MIN_CAPACITY) {
            return MIN_CAPACITY;
        }
        if (capacity > MAX_CAPACITY) {
            return MAX_CAPACITY;
        }
        return capacity;
    }

    private float calculateLoadFactor(float loadFactor) {
        if (loadFactor < MIN_LOAD_FACTOR) {
            return MIN_LOAD_FACTOR;
        }
        if (loadFactor > MAX_LOAD_FACTOR) {
            return MAX_LOAD_FACTOR;
        }
        return loadFactor;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void put(K key, V value) {
        insureCapacity();
        final var bucket = new MapBucket<>(key, value);
        final var bucketIndex = bucketIndex(key);
        putInBucket(bucketIndex, bucket);
    }

    @Override
    public V get(K key) {
        final var bucket = findBucket(key);
        if (bucket == null) {
            // not found
            return null;
        }
        return bucket.value;
    }

    @Override
    public boolean contains(K key) {
        final var bucket = findBucket(key);
        return bucket != null;
    }

    @Override
    public V remove(K key) {
        final var bucket = findAndRemoveBucket(key);
        if (bucket == null) {
            // not found
            return null;
        }
        return bucket.value;
    }

    @Override
    public void clear() {
        if (isNotEmpty()) {
            Arrays.fill(this.buckets, null);
            this.size = 0;
        }
    }

    private static final class MapBucket<K, V> {
        K key;
        V value;

        public MapBucket(K key, V value) {
            this.key = key;
            this.value = value;
        }

        MapBucket<K, V> next;
    }

    private void insureCapacity() {
        final int maxSize = (int) (this.capacity * this.loadFactor);
        if (this.size >= maxSize) {
            // increase capacity
            final int newCapacity = calculateCapacity(this.capacity << 1);
            if (newCapacity > this.capacity) {
                final var oldBuckets = this.buckets;
                this.capacity = newCapacity;
                this.size = 0;
                this.buckets = new MapBucket[this.capacity];
                for (MapBucket<K, V> bucket : oldBuckets) {
                    while (bucket != null) {
                        final var bucketIndex = bucketIndex(bucket.key);
                        putInBucket(bucketIndex, bucket);
                        bucket = bucket.next;
                    }
                }
            }
        }
    }

    private int bucketIndex(K key) {
        final int hashCode = key.hashCode();
        return hashCode % this.capacity;
    }

    private void putInBucket(int index,
                             MapBucket<K, V> bucket) {
        var iBucket = this.buckets[index];
        if (iBucket == null) {
            this.buckets[index] = bucket;
            this.size++;
        } else {
            boolean updated = false;
            var previous = iBucket;
            while (iBucket != null) {
                if (Objects.equals(bucket.key, iBucket.key)) {
                    iBucket.value = bucket.value;
                    updated = true;
                    break;
                }
                previous = iBucket;
                iBucket = iBucket.next;
            }
            if (!updated) {
                // not found, previous != null
                previous.next = bucket;
                this.size++;
            }
        }
    }

    private MapBucket<K, V> findBucket(K key) {
        return findBucketWithRemoval(key, false);
    }

    private MapBucket<K, V> findAndRemoveBucket(K key) {
        return findBucketWithRemoval(key, true);
    }

    private MapBucket<K, V> findBucketWithRemoval(K key,
                                                  boolean remove) {
        int index = bucketIndex(key);
        MapBucket<K, V> previous = null;
        var bucket = this.buckets[index];
        while (bucket != null) {
            if (Objects.equals(bucket.key, key)) {
                if (remove) {
                    if (previous != null) {
                        previous.next = bucket.next;
                    } else {
                        this.buckets[index] = bucket.next;
                    }
                    this.size--;
                }
                return bucket;
            }
            previous = bucket;
            bucket = bucket.next;
        }
        return null;
    }
}
