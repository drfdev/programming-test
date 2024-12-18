package dev.drf.prog.count.down.latch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsyncServiceTest {
    private AsyncService service;

    @BeforeEach
    void setUp() {
        this.service = new AsyncService();
    }

    @Test
    void countDownLatchExample() throws Exception {
        // prepare
        final int threadCount = 6;
        final int callCount = 1_000;

        var barrier = new CyclicBarrier(threadCount);
        var latch = new CountDownLatch(threadCount);

        var errorCounter = new AtomicInteger();

        // action
        for (int i = 0; i < threadCount; i++) {
            var thread = new Thread(() -> {
                try {
                    barrier.await();
                    for (int j = 0; j < callCount; j++) {
                        service.next();
                    }
                } catch (Exception ex) {
                    errorCounter.incrementAndGet();
                } finally {
                    latch.countDown();
                }
            });
            thread.start();
        }

        latch.await();

        // assert
        var value = service.current();
        assertEquals(6_000, value);
    }
}
