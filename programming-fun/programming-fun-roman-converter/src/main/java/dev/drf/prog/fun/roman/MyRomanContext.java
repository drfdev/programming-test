package dev.drf.prog.fun.roman;

final class MyRomanContext {
    public static final char EMPTY_CHAR = '\0';

    char current = EMPTY_CHAR;
    char previous = EMPTY_CHAR;

    int sum = 0;
    char validPrevious = EMPTY_CHAR;

    public void updateContext(char next) {
        this.previous = this.current;
        if (this.current != next) {
            this.validPrevious = this.previous;
        }
        this.current = next;
    }

    public boolean isValidCharEnabled() {
        return this.validPrevious != EMPTY_CHAR;
    }
}
