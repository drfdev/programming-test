package dev.drf.prog.count.down.latch;

import java.util.concurrent.atomic.AtomicInteger;

public class AsyncService {
    private final AtomicInteger counter = new AtomicInteger();

    public int next() {
        return counter.getAndIncrement();
    }

    public int current() {
        return counter.get();
    }
}
