package dev.drf.prog.awaitility;

import dev.drf.prog.common.AwaitAsync;
import dev.drf.prog.common.AwaitWithTimeout;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.equalTo;

public class AsyncServiceTest {
    private AsyncService asyncService;

    @BeforeEach
    public void setUp() {
        asyncService = new AsyncService();
    }

    @AwaitAsync
    @Test
    void example1() {
        // prepare
        Awaitility.setDefaultPollInterval(100L, TimeUnit.MILLISECONDS);
        Awaitility.setDefaultPollDelay(Duration.ZERO);
        Awaitility.setDefaultTimeout(Duration.ofMinutes(1L));

        // action
        asyncService.initialize();

        // assert
        Awaitility.await()
                .until(asyncService::isInitialized);
    }

    @AwaitAsync
    @Test
    void example2() {
        // prepare - assert
        asyncService.initialize();
        Awaitility.await()
                .until(asyncService::isInitialized);

        // action
        long value = 5;
        asyncService.addValue(value);

        // assert
        Awaitility.await()
                .until(asyncService::getValue, equalTo(value));
    }

    @AwaitWithTimeout
    @Test
    void example3_withException() {
        // action
        asyncService.initialize();

        // assert
        Awaitility.given().ignoreException(IllegalStateException.class)
                .await()
                .atLeast(Duration.ofMillis(500L))
                .atMost(Duration.ofSeconds(2L))
                .until(asyncService::getValue, equalTo(0L));
    }
}
