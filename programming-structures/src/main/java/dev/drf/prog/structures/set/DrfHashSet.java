package dev.drf.prog.structures.set;

import java.util.Arrays;
import java.util.Objects;

public final class DrfHashSet<T> implements HashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private static final float MIN_LOAD_FACTOR = 0.15f;
    private static final float MAX_LOAD_FACTOR = 1.0f;

    private static final int MIN_CAPACITY = 1;
    private static final int MAX_CAPACITY = 1 << 20;

    private int capacity;
    private final float loadFactor;

    private int size;
    private SetBucket<T>[] buckets;

    public DrfHashSet() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public DrfHashSet(int capacity) {
        this(capacity, DEFAULT_LOAD_FACTOR);
    }

    public DrfHashSet(int capacity, float loadFactor) {
        this.capacity = calculateCapacity(capacity);
        this.loadFactor = calculateLoadFactor(loadFactor);
        this.size = 0;
        this.buckets = new SetBucket[this.capacity];
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
        return size == 0;
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
    public void put(T key) {
        insureCapacity();
        final var bucket = new SetBucket<>(key);
        final var bucketIndex = bucketIndex(key);
        putInBucket(bucketIndex, bucket);
    }

    @Override
    public boolean contains(T key) {
        final var bucket = findBucket(key);
        return bucket != null;
    }

    @Override
    public boolean remove(T key) {
        final var bucket = findAndRemoveBucket(key);
        return bucket != null;
    }

    @Override
    public void clear() {
        if (isNotEmpty()) {
            Arrays.fill(this.buckets, null);
            this.size = 0;
        }
    }

    private static final class SetBucket<T> {
        final T object;
        SetBucket<T> next;

        public SetBucket(T object) {
            this.object = object;
        }
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
                this.buckets = new SetBucket[this.capacity];
                for (SetBucket<T> bucket : oldBuckets) {
                    while (bucket != null) {
                        final var bucketIndex = bucketIndex(bucket.object);
                        putInBucket(bucketIndex, bucket);
                        bucket = bucket.next;
                    }
                }
            }
        }
    }

    private int bucketIndex(T key) {
        final int hashCode = key.hashCode();
        return Math.abs(hashCode % this.capacity);
    }

    private void putInBucket(int index, SetBucket<T> bucket) {
        var iBucket = this.buckets[index];
        if (iBucket == null) {
            this.buckets[index] = bucket;
            this.size++;
        } else {
            var previous = iBucket;
            while (iBucket != null) {
                if (Objects.equals(bucket.object, iBucket.object)) {
                    // found: nothing to update
                    return;
                }
                previous = iBucket;
                iBucket = iBucket.next;
            }
            // not found, previous != null
            previous.next = bucket;
            this.size++;
        }
    }

    private SetBucket<T> findBucket(T key) {
        return findBucketWithRemoval(key, false);
    }

    private SetBucket<T> findAndRemoveBucket(T key) {
        return findBucketWithRemoval(key, true);
    }

    private SetBucket<T> findBucketWithRemoval(T key, boolean remove) {
        int index = bucketIndex(key);
        SetBucket<T> previous = null;
        var bucket = this.buckets[index];
        while (bucket != null) {
            if (Objects.equals(bucket.object, key)) {
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
