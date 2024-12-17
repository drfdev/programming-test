package dev.drf.prog.awaitility;

import java.util.concurrent.CompletableFuture;

public interface TestService {

    Object execute();

    CompletableFuture<Object> executeAsync();

}
