package ru.omsu.imit.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ReferenceTests extends Assert {
    private double a;
    private double b;
    private double expectedMax;

    public ReferenceTests(final double a, final double b, final double expectedMax) {
        this.a = a;
        this.b = b;
        this.expectedMax = expectedMax;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0.1, 1, 1},
                {0, 0, 0},
                {1, 1, 1},
                {10.2, 10.23, 10.23}
        });
    }

    @Test
    public void maxTest() {
        final double ACTUAL = LambdaDemo.reference.apply(a, b);

        assertEquals(expectedMax, ACTUAL, 0.001);
    }
}