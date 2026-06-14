package dev.drf.prog.structures.deque;

public final class DrfDeque<T> implements Deque<T> {
    private EntityWrapper<T> root;
    private EntityWrapper<T> last;

    @Override
    public boolean isEmpty() {
        return root == null && last == null;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public void addFirst(T value) {
        var wrapper = new EntityWrapper<>(value);
        if (isEmpty()) {
            addForEmpty(wrapper);
        } else {
            this.root.previous = wrapper;
            wrapper.next = this.root;
            this.root = wrapper;
        }
    }

    @Override
    public T popFirst() {
        checkAndThrowForEmptyDeque();
        var value = this.root.object;
        this.root = root.next;
        if (this.root == null) {
            this.last = null;
        }
        return value;
    }

    @Override
    public T peekFirst() {
        checkAndThrowForEmptyDeque();
        return this.root.object;
    }

    @Override
    public void addLast(T value) {
        var wrapper = new EntityWrapper<>(value);
        if (isEmpty()) {
            addForEmpty(wrapper);
        } else {
            this.last.next = wrapper;
            wrapper.previous = this.last;
            this.last = wrapper;
        }
    }

    @Override
    public T popLast() {
        checkAndThrowForEmptyDeque();
        var value = this.last.object;
        this.last = last.previous;
        if (this.last == null) {
            this.root = null;
        }
        return value;
    }

    @Override
    public T peekLast() {
        checkAndThrowForEmptyDeque();
        return this.last.object;
    }

    private static final class EntityWrapper<T> {
        T object;
        EntityWrapper<T> next;
        EntityWrapper<T> previous;

        public EntityWrapper(T object) {
            this.object = object;
        }
    }

    private void checkAndThrowForEmptyDeque() {
        if (isEmpty()) {
            throw new EmptyDequeException();
        }
    }

    private void addForEmpty(EntityWrapper<T> wrapper) {
        this.root = wrapper;
        this.last = wrapper;
    }
}
