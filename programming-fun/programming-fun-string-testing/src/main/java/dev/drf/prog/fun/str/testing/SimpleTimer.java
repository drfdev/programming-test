package dev.drf.prog.fun.str.testing;

public final class SimpleTimer {
    private final long time;

    private SimpleTimer(long time) {
        this.time = time;
    }

    public static SimpleTimer newTimer() {
        return new SimpleTimer(System.nanoTime());
    }

    public long stop() {
        final long nextTime = System.nanoTime();
        return nextTime - this.time;
    }

    @Override
    public String toString() {
        return "SimpleTimer{" +
                "time=" + time +
                '}';
    }
}
