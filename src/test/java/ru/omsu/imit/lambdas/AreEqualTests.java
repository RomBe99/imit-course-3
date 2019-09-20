package ru.omsu.imit.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AreEqualTests extends Assert {
    private int a;
    private int b;
    private boolean expectedBool;

    public AreEqualTests(final int a, final int b, final boolean expectedBool) {
        this.a = a;
        this.b = b;
        this.expectedBool = expectedBool;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, true},
                {0, 1, false},
                {22, 55, false},
                {-22, -55, false},
                {-22, 55, false},
                {-22, -22, true},
                {55, 55, true}
        });
    }

    @Test
    public void areEqualTest() {
        final boolean ACTUAL = LambdaDemo.areEqual.test(a, b);

        assertEquals(expectedBool, ACTUAL);
    }
}