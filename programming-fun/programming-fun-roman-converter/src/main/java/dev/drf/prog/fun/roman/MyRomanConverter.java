package dev.drf.prog.fun.roman;

import java.util.Map;
import java.util.Set;

public class MyRomanConverter implements RomanConverter {
    private static final Map<Character, Integer> ROMAN_NUMERALS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);
    /*
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
     */
    private static final Set<NumeralPrefixes> NUMERAL_PREFIXES = Set.of(
            NumeralPrefixes.of('V', 'I'),
            NumeralPrefixes.of('X', 'I'),
            NumeralPrefixes.of('L', 'X'),
            NumeralPrefixes.of('C', 'X'),
            NumeralPrefixes.of('D', 'C'),
            NumeralPrefixes.of('M', 'C')
    );

    private static final String[] ILLEGAL_PATTERNS = {
            "VIV", "IVI", "IXI", "IXV", "LXL", "XLX",
            "XCX", "XCL", "DCD", "CDC", "CMC", "CMD",
            "IIII", "VV", "XXXX", "LL", "CCCC", "DD", "MMMM"
    };

    @Override
    public int convert(String roman) throws InvalidRomanNumeralException {
        if (roman == null) {
            throw new NullPointerException("Roman literal is null");
        }
        if (roman.isEmpty()) {
            return 0;
        }
        if (hasIllegalPatterns(roman)) {
            throw new InvalidRomanNumeralException("Incorrect roman string: " + roman);
        }

        final char[] romanChars = roman.toCharArray();
        final MyRomanContext context = new MyRomanContext();

        for (int i = romanChars.length - 1; i >= 0; i--) {
            final char next = romanChars[i];
            if (!ROMAN_NUMERALS.containsKey(next)) {
                throw new InvalidRomanNumeralException("Unknown symbol: " + next);
            }

            context.updateContext(next);
            validateAndUpdateSum(context);
        }

        return context.sum;
    }

    private boolean hasIllegalPatterns(String roman) {
        for (String illegalPattern : ILLEGAL_PATTERNS) {
            if (roman.contains(illegalPattern)) {
                return true;
            }
        }
        return false;
    }

    private void validateAndUpdateSum(MyRomanContext context) throws InvalidRomanNumeralException {
        final char curr = context.current;
        final char prev = context.previous;

        if (NUMERAL_PREFIXES.contains(NumeralPrefixes.of(prev, curr))) {
            context.sum = context.sum - ROMAN_NUMERALS.get(curr);
        } else {
            checkValidPrevious(context);
            context.sum = context.sum + ROMAN_NUMERALS.get(curr);
        }
    }

    private void checkValidPrevious(MyRomanContext context) throws InvalidRomanNumeralException {
        if (context.isValidCharEnabled()) {
            final char curr = context.current;
            final char valid = context.validPrevious;

            final int currValue = ROMAN_NUMERALS.get(curr);
            final int validValue = ROMAN_NUMERALS.get(valid);
            if (currValue < validValue) {
                throw new InvalidRomanNumeralException("Unknown symbols order: "
                        + curr + " before " + valid);
            }
        }
    }
}
