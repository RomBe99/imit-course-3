package ru.omsu.imit.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SumTests extends Assert {
    private List<Integer> testList;
    private int expectedInt;

    public SumTests(final List<Integer> testList, final int expectedInt) {
        this.testList = testList;
        this.expectedInt = expectedInt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 3, 4, 5), 15},
                {Arrays.asList(-1, -2, -3, -4, -5), -15},
                {Arrays.asList(-1, 2, -3, 4, -5), -3},
                {Collections.EMPTY_LIST, 0}
        });
    }

    @Test
    public void sumTest() {
        final int ACTUAL = LambdaDemo.sum.apply(testList);

        assertEquals(expectedInt, ACTUAL);
    }
}