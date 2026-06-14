package dev.drf.prog.structures.queue;

public final class DrfQueue<T> implements Queue<T> {
    private ValueWrapper<T> root;
    private ValueWrapper<T> last;

    @Override
    public boolean isEmpty() {
        return root == null && last == null;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public void add(T value) {
        var wrapper = new ValueWrapper<T>(value);
        if (isEmpty()) {
            this.root = wrapper;
            this.last = wrapper;
        } else {
            this.last.next = wrapper;
            this.last = wrapper;
        }
    }

    @Override
    public T pop() {
        checkAndThrowForEmptyQueue();
        var value = this.root.object;
        this.root = root.next;
        if (this.root == null) {
            this.last = null;
        }
        return value;
    }

    @Override
    public T peek() {
        checkAndThrowForEmptyQueue();
        return this.root.object;
    }

    private static final class ValueWrapper<T> {
        T object;
        ValueWrapper<T> next;
        ValueWrapper<T> previous;

        public ValueWrapper(T object) {
            this.object = object;
        }
    }

    private void checkAndThrowForEmptyQueue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
    }
}
