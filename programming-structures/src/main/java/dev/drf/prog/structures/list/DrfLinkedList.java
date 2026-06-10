package dev.drf.prog.structures.list;

import java.util.Iterator;

public final class DrfLinkedList<T> implements LinkedList<T> {
    private EntityWrapper<T> root;
    private EntityWrapper<T> last;
    private int length;

    public DrfLinkedList() {
        this.root = null;
        this.last = null;
        this.length = 0;
    }

    @Override
    public int len() {
        return length;
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
        var wrapper = searchByIndex(index);
        return wrapper.object;
    }

    @Override
    public void add(T value) {
        addLast(value);
    }

    @Override
    public T set(int index, T value) {
        checkIndex(index);
        var wrapper = searchByIndex(index);
        var previous = wrapper.object;
        wrapper.object = value;
        return previous;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removed;
        if (this.length == 1) {
            removed = this.root.object;
            this.root = null;
            this.last = null;
        } else {
            var wrapper = searchByIndex(index);
            removed = wrapper.object;

            final var previous = wrapper.previous;
            final var next = wrapper.next;
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
            wrapper.clear();
        }
        this.length--;
        return removed;
    }

    @Override
    public T getFirst() {
        if (this.root == null) {
            throw new IndexOutOfBoundsException("There is no first element");
        }
        return this.root.object;
    }

    @Override
    public T getLast() {
        if (this.last == null) {
            throw new IndexOutOfBoundsException("There is no last element");
        }
        return this.last.object;
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
        var wrapper = buildWrapper(value);
        if (isEmpty()) {
            root = wrapper;
            last = wrapper;
        } else {
            this.root.previous = wrapper;
            wrapper.next = this.root;
            this.root = wrapper;
        }
        this.length++;
    }

    @Override
    public void addLast(T value) {
        var wrapper = buildWrapper(value);
        if (isEmpty()) {
            root = wrapper;
            last = wrapper;
        } else {
            this.last.next = wrapper;
            wrapper.previous = this.last;
            this.last = wrapper;
        }
        this.length++;
    }

    @Override
    public Iterator<T> iterator() {
        return new DrfLinkedListIterator<>(this.root);
    }

    private static final class EntityWrapper<T> {
        T object;
        EntityWrapper<T> next;
        EntityWrapper<T> previous;

        public EntityWrapper(T object) {
            this.object = object;
        }

        void clear() {
            this.object = null;
            this.next = null;
            this.previous = null;
        }
    }

    private static final class DrfLinkedListIterator<T> implements Iterator<T> {
        private EntityWrapper<T> node;

        public DrfLinkedListIterator(EntityWrapper<T> root) {
            this.node = root;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            final var value = node.object;
            node = node.next;
            return value;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Index " + index + " must be in range [0, " + this.length + "]");
        }
    }

    private EntityWrapper<T> searchByIndex(int index) {
        if (index == 0) {
            return this.root;
        }
        if (index == length - 1) {
            return this.last;
        }

        final int middle = this.length / 2;
        EntityWrapper<T> result;
        if (index < middle) {
            // root --> current
            int currentIndex = 0;
            result = root;
            while (currentIndex < index
                    && currentIndex < length
                    && result != null) {
                result = result.next;
                currentIndex++;
            }
        } else {
            // current <-- last
            int currentIndex = this.length - 1;
            result = last;
            while (currentIndex >= 0
                    && currentIndex > index
                    && result != null) {
                result = result.previous;
                currentIndex--;
            }
        }
        return result;
    }

    private EntityWrapper<T> buildWrapper(T value) {
        return new EntityWrapper<>(value);
    }
}
