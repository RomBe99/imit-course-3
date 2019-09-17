package ru.omsu.imit.lambdas.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SplitAndCountTests extends Assert {
    private String testString;
    private int expectedInt;

    public SplitAndCountTests(final String testString, final Integer expectedInt) {
        this.testString = testString;
        this.expectedInt = expectedInt;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Мама мыла раму", 3},
                {"Мама", 1},
                {"", 1}
        });
    }

    @Test
    public void splitAndCountTest() {
        final int ACTUAL = LambdaDemo.splitAndCount.apply(testString);

        assertEquals(expectedInt, ACTUAL);
    }
}