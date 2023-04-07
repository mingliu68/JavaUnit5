
package com.junittest;

import static org.junit.Assert.*;

import org.junit.Test;


public class BalancedBracketsTest  
{
  
    String balancedParens = "(1)";
    String tooManyOpenParens = "((1";
    String tooManyOpenParens1 = "(1)(";
    String tooManyClosedParens = "(1))";
    String startClosedParens = ")(";
    String emptyString = "";
    String balancedAngleBrackets = "<<>>";
    String balancedComboBrackets = "<({})>";
    String mismatchedBrackets = "<({)}>";

    BalancedBrackets balancedBrackets = new BalancedBrackets();


    // test for assertTrue and assertFalse
    @Test
    public void testBalancedBrackets_BalancedParens() {
        assertTrue(balancedBrackets.isBalanced(balancedParens));
    }

    @Test 
    public void testBalancedBrackets_TooManyOpenParens() {
        assertFalse(balancedBrackets.isBalanced(tooManyOpenParens));
        assertFalse(balancedBrackets.isBalanced(tooManyOpenParens1));
    }

    @Test
    public void testBalancedBrackets_TooManyClosedParens() {
        assertFalse(balancedBrackets.isBalanced(tooManyClosedParens));
    }

    @Test 
    public void testBalancedBrackets_StartWithClosedParens() {
        assertFalse(balancedBrackets.isBalanced(startClosedParens));
    }

    @Test
    public void testBalancedBrackets_EmptyString() {
        assertTrue(balancedBrackets.isBalanced(emptyString));
    }

    @Test
    public void testBalancedBrackets_BalancedAngleBrackets() {
        assertTrue(balancedBrackets.isBalanced(balancedAngleBrackets));
    }

    @Test
    public void testBalancedBrackets_BalancedComboBrackets() {
        assertTrue(balancedBrackets.isBalanced(balancedComboBrackets));
    }

    @Test
    public void testBalancedBrackets_MismatchedBrackets() {
        assertFalse(balancedBrackets.isBalanced(mismatchedBrackets));
    }

}
