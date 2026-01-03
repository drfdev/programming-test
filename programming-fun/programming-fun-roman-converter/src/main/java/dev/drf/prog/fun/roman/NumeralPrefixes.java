package dev.drf.prog.fun.roman;

public record NumeralPrefixes(char left,
                              char right) {
    public static NumeralPrefixes of(char left,
                                     char right) {
        return new NumeralPrefixes(left, right);
    }
}
