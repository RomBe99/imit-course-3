package ru.omsu.imit.nio;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class NIODemoTests extends Assert {
    @Test
    public void writeAndReadNumbersFromFileTest1() throws IOException {
        final int SIZE = 100;
        int[] expectedInts = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            expectedInts[i] = i;
        }

        final File FILE_FOR_WRITE_AND_READ = new File("ints.txt");

        try {
            final int[] ACTUAL = NIODemo.writeAndReadNumbersFromFile(FILE_FOR_WRITE_AND_READ);

            assertArrayEquals(expectedInts, ACTUAL);
        } finally {
            if (FILE_FOR_WRITE_AND_READ.exists()) {
                FILE_FOR_WRITE_AND_READ.delete();
            }
        }
    }
}