
package com.junittest;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MissingNumberTest 
{
    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };

    private MissingNumber missingNumber = new MissingNumber();

    // assert equals
    @Test
    public void testMissingNumber_MissingMax()
    {
        assertEquals(10, missingNumber.findMissingNumber_N(missingMax, 10));
        assertEquals(10, missingNumber.findMissingNumber_NLOGN(missingMax, 10));
        assertEquals(10, missingNumber.findMissingNumber_N_1(missingMax, 10));

    }

    @Test 
    public void testMissingNumber_MissingNone() {
        assertEquals(0, missingNumber.findMissingNumber_N(missingNone, 10));
        assertEquals(0, missingNumber.findMissingNumber_NLOGN(missingNone, 10));
        assertEquals(0, missingNumber.findMissingNumber_N_1(missingNone, 10));

    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(7, missingNumber.findMissingNumber_N(missingSeven, 10));
        assertEquals(7, missingNumber.findMissingNumber_NLOGN(missingSeven, 10));
        assertEquals(7, missingNumber.findMissingNumber_N_1(missingSeven, 10));

    }
}
