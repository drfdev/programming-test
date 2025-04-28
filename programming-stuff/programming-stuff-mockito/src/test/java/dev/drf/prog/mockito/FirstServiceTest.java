package dev.drf.prog.mockito;

import dev.drf.prog.common.AwaitWithTimeout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(MockitoExtension.class)
public class FirstServiceTest {
    @Mock
    private SecondService service;

    private FirstService firstService;

    @BeforeEach
    void setUp() {
        this.firstService = new FirstService(service);
    }

    @Test
    void example1() {
        // prepare
        Mockito.when(service.calculate(anyInt(), any()))
                .thenReturn("result-value");

        // action
        var result = firstService.calculateType(10);

        // assert
        assertEquals("result-value", result);
    }

    @Test
    void example2() {
        // prepare
        Mockito.when(service.calculate(anyInt(), any()))
                .thenReturn("result-value");

        // action
        firstService.calculateType(10);

        // assert
        var numberCaptor = ArgumentCaptor.forClass(int.class);
        var valueCaptor = ArgumentCaptor.forClass(String.class);
        Mockito.verify(service).calculate(numberCaptor.capture(), valueCaptor.capture());

        var number = numberCaptor.getValue();
        var value = valueCaptor.getValue();

        assertEquals(10, number);
        assertEquals("second-service", value);
    }

    @Test
    void example3() {
        // prepare
        int from = 10;
        int to = 25;
        Mockito.when(service.additionalType())
                .thenReturn("add-type");
        Mockito.when(service.calculate(anyInt(), any()))
                .thenAnswer(it -> {
                    int number = it.getArgument(0, Integer.class);
                    var type = it.getArgument(1, String.class);
                    if (Objects.equals("add-type", type)) {
                        if (number == 10) {
                            return "added-10";
                        } else {
                            return "added-25";
                        }
                    } else {
                        if (number == 10) {
                            return "result-10";
                        } else {
                            return "result-25";
                        }
                    }
                });

        // action
        firstService.calculateDeeply(from, to);

        // assert
        InOrder inOrder = Mockito.inOrder(service);

        inOrder.verify(service).calculate(eq(10), eq("second-service"));
        inOrder.verify(service).calculate(eq(25), eq("second-service"));

        inOrder.verify(service).additionalType();

        inOrder.verify(service).calculate(eq(10), eq("add-type"));
        inOrder.verify(service).calculate(eq(25), eq("add-type"));

        inOrder.verifyNoMoreInteractions();
    }

    @AwaitWithTimeout
    @Test
    void example4_withTimeout() {
        // prepare
        Mockito.when(service.calculate(anyInt(), any()))
                .thenReturn("result-value");

        // action
        firstService.calculateType(10);

        // assert
        Mockito.verify(service, Mockito.timeout(2000L))
                .calculate(anyInt(), any());
    }

    @Test
    void example5() {
        // prepare
        int from = 10;
        int to = 25;
        Mockito.when(service.additionalType())
                .thenReturn("add-type");
        Mockito.when(service.calculate(anyInt(), any()))
                .thenAnswer(it -> {
                    int number = it.getArgument(0, Integer.class);
                    var type = it.getArgument(1, String.class);
                    if (Objects.equals("add-type", type)) {
                        if (number == 10) {
                            return "added-10";
                        } else {
                            return "added-25";
                        }
                    } else {
                        if (number == 10) {
                            return "result-10";
                        } else {
                            return "result-25";
                        }
                    }
                });

        // action
        firstService.calculateDeeply(from, to);

        // assert
        Mockito.verify(service, Mockito.times(4))
                .calculate(anyInt(), any());
        Mockito.verify(service, Mockito.atLeastOnce())
                .additionalType();
    }
}
