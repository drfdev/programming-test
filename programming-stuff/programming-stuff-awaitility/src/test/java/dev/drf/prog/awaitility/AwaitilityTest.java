package dev.drf.prog.awaitility;

import dev.drf.prog.common.AwaitAsync;
import dev.drf.prog.common.AwaitWithTimeout;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class AwaitilityTest {
    @Mock
    private TestService service;

    @Test
    void example1() {
        // prepare
        Mockito.when(service.execute()).thenReturn("test-result");

        // action
        var result = service.execute();

        // assert
        assertNotNull(result);
        assertEquals("test-result", result);
    }

    @AwaitAsync
    @Test
    void example2() throws Exception {
        // prepare
        Mockito.when(service.executeAsync())
                .thenReturn(CompletableFuture.completedFuture("test-result-2"));

        // action
        var future = service.executeAsync();

        // assert
        Awaitility.await()
                .until(future::isDone);

        var result = future.get();
        assertEquals("test-result-2", result);
    }

    @AwaitWithTimeout
    @Test
    void example3() throws Exception {
        // prepare
        Mockito.when(service.executeAsync())
                .thenReturn(CompletableFuture.completedFuture("test-result-3"));

        // action
        var future = service.executeAsync();

        // assert
        Awaitility.await()
                .atLeast(Duration.ofMillis(100L))
                .atMost(Duration.ofSeconds(5L))
                .with()
                .pollInterval(Duration.ofMillis(100L))
                .pollDelay(Duration.ofMillis(100L))
                .until(future::isDone);

        var result = future.get();
        assertEquals("test-result-3", result);
    }
}
