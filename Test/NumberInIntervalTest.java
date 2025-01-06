import org.junit.jupiter.api.Test;
import task2.NumberInInterval;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberInIntervalTest{

    @Test
    void numberInsideInterval(){
        NumberInInterval numberInInterval = new NumberInInterval();
        assertTrue(numberInInterval.numberInInterval(50));
    }

    @Test
    void numberBelowLowerBoundary(){
        NumberInInterval numberInInterval = new NumberInInterval();
        assertFalse(numberInInterval.numberInInterval(25));
    }

    @Test
    void numberAboveUpperBoundary(){
        NumberInInterval numberInInterval = new NumberInInterval();
        assertFalse(numberInInterval.numberInInterval(100));
    }

    @Test
    void numberOutsideBelow(){
        NumberInInterval numberInInterval = new NumberInInterval();
        assertFalse(numberInInterval.numberInInterval(10));
    }

    @Test
    void numberOutsideAbove(){
        NumberInInterval numberInInterval = new NumberInInterval();
        assertFalse(numberInInterval.numberInInterval(150));
    }
}
