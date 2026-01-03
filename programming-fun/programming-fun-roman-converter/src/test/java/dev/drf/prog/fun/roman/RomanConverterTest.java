package dev.drf.prog.fun.roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanConverterTest {
    private final RomanConverter converter = new MyRomanConverter();

    private void assertInvalid(String r) {
        assertThrows(InvalidRomanNumeralException.class, () -> converter.convert(r));
    }

    @Test
    public void valid() throws Exception {
        assertEquals(0, converter.convert(""));
        assertEquals(1, converter.convert("I"));
        assertEquals(2, converter.convert("II"));
        assertEquals(3, converter.convert("III"));
        assertEquals(4, converter.convert("IV"));
        assertEquals(5, converter.convert("V"));
        assertEquals(6, converter.convert("VI"));
        assertEquals(7, converter.convert("VII"));
        assertEquals(8, converter.convert("VIII"));
        assertEquals(9, converter.convert("IX"));
        assertEquals(10, converter.convert("X"));
        assertEquals(11, converter.convert("XI"));
        assertEquals(12, converter.convert("XII"));
        assertEquals(13, converter.convert("XIII"));
        assertEquals(14, converter.convert("XIV"));
        assertEquals(15, converter.convert("XV"));
        assertEquals(16, converter.convert("XVI"));
        assertEquals(19, converter.convert("XIX"));
        assertEquals(20, converter.convert("XX"));
        assertEquals(30, converter.convert("XXX"));
        assertEquals(40, converter.convert("XL"));
        assertEquals(50, converter.convert("L"));
        assertEquals(60, converter.convert("LX"));
        assertEquals(74, converter.convert("LXXIV"));
        assertEquals(90, converter.convert("XC"));
        assertEquals(100, converter.convert("C"));
        assertEquals(114, converter.convert("CXIV"));
        assertEquals(190, converter.convert("CXC"));
        assertEquals(400, converter.convert("CD"));
        assertEquals(500, converter.convert("D"));
        assertEquals(444, converter.convert("CDXLIV"));
        assertEquals(694, converter.convert("DCXCIV"));
        assertEquals(900, converter.convert("CM"));
        assertEquals(1000, converter.convert("M"));
        assertEquals(1900, converter.convert("MCM"));
        assertEquals(1999, converter.convert("MCMXCIX"));
        assertEquals(2024, converter.convert("MMXXIV"));
    }

    @Test
    public void invalid() {
        assertInvalid("ABE");
        assertInvalid("IIII");
        assertInvalid("VV");
        assertInvalid("XXXX");
        assertInvalid("LL");
        assertInvalid("CCCC");
        assertInvalid("DD");
        assertInvalid("MMMM");
        assertInvalid("XIIII");
        assertInvalid("LXXXX");
        assertInvalid("DCCCC");
        assertInvalid("VIIII");
        assertInvalid("MCCCC");
        assertInvalid("VX");
        assertInvalid("IIV");
        assertInvalid("IVI");
        assertInvalid("IXI");
        assertInvalid("IXV");
        assertInvalid("VIV");
        assertInvalid("XVX");
        assertInvalid("XVV");
        assertInvalid("XIVI");
        assertInvalid("XIXI");
        assertInvalid("XVIV");
        assertInvalid("LXL");
        assertInvalid("XLX");
        assertInvalid("XCX");
        assertInvalid("XCL");
        assertInvalid("CDC");
        assertInvalid("DCD");
        assertInvalid("CMC");
        assertInvalid("CMD");
        assertInvalid("MCMC");
        assertInvalid("MCDM");
    }
}
