package tudelft.roman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RomanNumeralTest {


    @Test
    public void singleNumber() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("I");
        Assertions.assertEquals(1, result);
    }

    @Test
    public void numberWithManyDigits() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("VIII");
        Assertions.assertEquals(8, result);
    }

    @Test
    public void numberWithSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("IV");
        Assertions.assertEquals(4, result);
    }

    @Test
    public void numberWithAndWithoutSubtractiveNotation() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV");
        Assertions.assertEquals(44, result);
    }

    @Test
    public void hugeNumberTest() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("MMMDCXLIV");
        Assertions.assertEquals(3644, result);
    }

    @Test
    public void smalleNumberTest() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XXC");
        Assertions.assertEquals(0, result);
    }

    @Test
    public void incorrectStringTest() {
        RomanNumeral roman = new RomanNumeral();
        int result = roman.convert("XLIV4");
        Assertions.assertEquals(0, result);
        result = roman.convert("XaLIV");
        Assertions.assertEquals(0, result);
        result = roman.convert(null);
        Assertions.assertEquals(0, result);
    }
}
