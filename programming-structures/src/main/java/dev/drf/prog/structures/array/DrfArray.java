package dev.drf.prog.structures.array;

public final class DrfArray<T> implements Array<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] arr;
    private int length;

    public DrfArray() {
        this(DEFAULT_SIZE);
    }

    public DrfArray(int initialCapacity) {
        this.arr = new Object[initialCapacity];
        this.length = 0;
    }

    @Override
    public int len() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) this.arr[index];
    }

    @Override
    public void add(T value) {
        this.addElement(this.length, value);
    }

    @Override
    public void addByIndex(int index, T value) {
        if (index == this.length) {
            add(value);
            return;
        }
        checkIndex(index);
        this.addElement(index, value);
    }

    @Override
    public T set(int index, T value) {
        checkIndex(index);
        return this.setElement(index, value);
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        return this.removeElement(index);
    }

    @Override
    public T getFirst() {
        return this.get(0);
    }

    @Override
    public T getLast() {
        return this.get(this.length - 1);
    }

    @Override
    public T setFirst(T value) {
        return this.set(0, value);
    }

    @Override
    public T setLast(T value) {
        return this.set(this.length - 1, value);
    }

    @Override
    public void addFirst(T value) {
        this.addByIndex(0, value);
    }

    @Override
    public void addLast(T value) {
        this.add(value);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Index " + index + " must be in range [0, " + this.length + "]");
        }
    }

    private void addElement(int index, T value) {
        this.insureCapacity(this.length + 1);
        if (index < this.length) {
            insertElement(index, value);
        } else {
            this.arr[index] = value;
            this.length++;
        }
    }

    private T setElement(int index, T value) {
        this.insureCapacity(this.length + 1);
        T previous = (T) this.arr[index];
        this.arr[index] = value;
        return previous;
    }

    private T removeElement(int index) {
        T removed = (T) this.arr[index];
        System.arraycopy(this.arr, index + 1, this.arr, index, this.length - index - 1);
        this.length--;
        return removed;
    }

    private void insureCapacity(int len) {
        if (arr.length < len) {
            final int newSize = this.calculateNewSize(len);
            Object[] biggerArr = new Object[newSize];

            System.arraycopy(this.arr, 0, biggerArr, 0, this.length);
            this.arr = biggerArr;
        }
    }

    private int calculateNewSize(int len) {
        int doubledLength = arr.length * 2;
        if (doubledLength < 0) {
            doubledLength = Integer.MAX_VALUE;
        }
        return Math.max(doubledLength, len);
    }

    private void insertElement(int index, T value) {
        System.arraycopy(this.arr, index, this.arr, index + 1, this.length - index);
        this.arr[index] = value;
        this.length++;
    }
}
