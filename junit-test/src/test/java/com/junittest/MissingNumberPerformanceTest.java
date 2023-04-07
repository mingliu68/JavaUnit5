package com.junittest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MissingNumberPerformanceTest {

    private int[] missingMax = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private int[] missingNone = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };

    int max = 10;

    private MissingNumber missingNumber = new MissingNumber();

    @Test(timeout = 100)
    public void testMissingNumberN_Performance() {
        for(int i = 0; i < 1000000; i++) {
            missingNumber.findMissingNumber_N(missingMax, max);
            missingNumber.findMissingNumber_N(missingNone, max);
            missingNumber.findMissingNumber_N(missingSeven, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumberNLOGN_Performance() {
        for(int i = 0; i < 1000000; i++) {
            missingNumber.findMissingNumber_NLOGN(missingMax, max);
            missingNumber.findMissingNumber_NLOGN(missingNone, max);
            missingNumber.findMissingNumber_NLOGN(missingSeven, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumberN1_Performance() {
        for(int i = 0; i < 1000000; i++) {
            missingNumber.findMissingNumber_N_1(missingMax, max);
            missingNumber.findMissingNumber_N_1(missingNone, max);
            missingNumber.findMissingNumber_N_1(missingSeven, max);
        }
    }

}
    
