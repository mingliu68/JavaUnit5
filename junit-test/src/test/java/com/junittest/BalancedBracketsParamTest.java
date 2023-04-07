package com.junittest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BalancedBracketsParamTest {
    
    private String input;
    private boolean expectedOutput;
    BalancedBracketsParam balancedBracketsParam = new BalancedBracketsParam();

    public BalancedBracketsParamTest(String input, boolean expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        String balancedParens = "(1)";
        String tooManyOpenParens = "((1";
        String tooManyOpenParens1 = "(1)(";
        String tooManyClosedParens = "(1))";
        String startClosedParens = ")(";
        String emptyString = "";
        String balancedAngleBrackets = "<<>>";
        String balancedComboBrackets = "<({})>";
        String mismatchedBrackets = "<({)}>";

        Object[][] expectedOutputs = {
            { balancedParens, true },
            { balancedAngleBrackets, true },
            { balancedComboBrackets, true },
            { emptyString, true },
            { tooManyOpenParens, false },
            { tooManyOpenParens1, false },
            { tooManyClosedParens, false },
            { startClosedParens, false },
            { mismatchedBrackets, false }
        };

        return Arrays.asList(expectedOutputs);
    }
    

    @Test
    public void testBalancedBracketsParam() {
        assertEquals(expectedOutput, balancedBracketsParam.isBalanced(input));
    }
}
