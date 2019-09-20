package ru.omsu.imit.lambdas;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.omsu.imit.lambdas.LambdaDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

@RunWith(Parameterized.class)
public class TransformTests extends Assert {
    private IntStream testIntStream;
    private IntUnaryOperator testOp;
    private int[] expectedIntStream;

    public TransformTests(final IntStream testIntStream, final IntUnaryOperator testOp, final IntStream expectedIntStream) {
        this.testIntStream = testIntStream;
        this.testOp = testOp;
        this.expectedIntStream = expectedIntStream.toArray();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IntStream.rangeClosed(5, 10), (IntUnaryOperator) i -> i * 2, IntStream.of(10, 12, 14, 16, 18, 20)},
                {IntStream.rangeClosed(1, 5), (IntUnaryOperator) i -> -i, IntStream.of(-1, -2, -3, -4, -5)},
                {IntStream.rangeClosed(-5, 0), (IntUnaryOperator) i -> -i, IntStream.of(5, 4, 3, 2, 1, 0)}
        });
    }

    @Test
    public void transformTest() {
        final int[] ACTUAL = LambdaDemo.transform.apply(testIntStream, testOp).toArray();

        assertArrayEquals(expectedIntStream, ACTUAL);
    }
}