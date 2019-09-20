package ru.omsu.imit.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsEvenTests extends Assert {
    private int testInt;
    private boolean expectedBool;

    public IsEvenTests(final int testInt, final boolean expectedBool) {
        this.testInt = testInt;
        this.expectedBool = expectedBool;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, true},
                {3, false},
                {228, true},
        });
    }

    @Test
    public void isEvenTest() {
        final boolean ACTUAL = LambdaDemo.isEven.test(testInt);

        assertEquals(expectedBool, ACTUAL);
    }
}