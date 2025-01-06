import org.junit.jupiter.api.Test;
import task1.EvenOddNumber;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EvenOddNumberTest {
    @Test
    void evenNumber() {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        assertTrue(evenOddNumber.evenOddNumber(4), "Число 4 должно быть чётным");
    }

    @Test
    void oddNumber() {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        assertFalse(evenOddNumber.evenOddNumber(3), "Число 3 должно быть нечётным");
    }

    @Test
    void zeroIsEven() {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        assertTrue(evenOddNumber.evenOddNumber(0), "Число 0 должно быть чётным");
    }

    @Test
    void negativeEvenNumber() {
        EvenOddNumber evenOddNumber = new EvenOddNumber();
        assertTrue(evenOddNumber.evenOddNumber(-6), "Число -6 должно быть чётным");
    }

    @Test
    void negativeOddNumber() {

        EvenOddNumber evenOddNumber = new EvenOddNumber();
        assertFalse(evenOddNumber.evenOddNumber(-7), "Число -7 должно быть нечётным");
    }
}
