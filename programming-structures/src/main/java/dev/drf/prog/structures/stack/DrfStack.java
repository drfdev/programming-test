package dev.drf.prog.structures.stack;

import java.util.EmptyStackException;

public final class DrfStack<T> implements Stack<T> {
    private ValueWrapper<T> root;

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public void push(T value) {
        final var wrapped = new ValueWrapper<>(value);
        wrapped.next = root;
        this.root = wrapped;
    }

    @Override
    public T pop() {
        checkAndThrowForEmptyStack();
        final var popped = root.object;
        root = root.next;
        return popped;
    }

    @Override
    public T peek() {
        checkAndThrowForEmptyStack();
        return root.object;
    }

    private void checkAndThrowForEmptyStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
    }

    private static final class ValueWrapper<T> {
        T object;
        ValueWrapper<T> next;

        public ValueWrapper(T object) {
            this.object = object;
        }
    }
}
