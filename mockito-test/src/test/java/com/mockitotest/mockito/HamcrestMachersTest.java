package com.mockitotest.mockito;

// import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
// import static org.hamcrest.Matchers.hasSize;
// import static org.hamcrest.Matchers.hasItems;




import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMachersTest {
    
    @Test
    public void test() {
        List<Integer> scores = Arrays.asList(99,100,101,105);

        // scores has 4 items
        assertThat(scores,hasSize(4));
        assertThat(scores, hasItem(105));
        assertThat(scores,hasItems(99, 100, 101));

        // every item : > 90
        assertThat(scores, everyItem(greaterThan(90)));

        // every item : < 190
        assertThat(scores, everyItem(lessThan(190)));

        // String
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        // Arrays
        Integer[] marks = {1, 2, 3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1, 2, 3));
        assertThat(marks, arrayContainingInAnyOrder(1,2,3));
        assertThat(marks, hasItemInArray(3));
    }
}
