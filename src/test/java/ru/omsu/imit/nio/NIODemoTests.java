package ru.omsu.imit.nio;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

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
            Files.deleteIfExists(FILE_FOR_WRITE_AND_READ.toPath());
        }
    }

    @Test
    public void changeFilesExtensionTest1() throws IOException {
        final String OLD_EXTENSION = ".dat";
        final String NEW_EXTENSION = ".bin";
        final File DIR_FOR_TEST = new File("./testCat/");
        final List<String> FILES_FOR_TEST = Arrays.asList(
                "3310.bin", "a.b", "backup.dat", "code55.bin", "data", "t.dat", "test1.dat", "test222.dat", "text.data");
        File[] files = null;

        assertTrue(DIR_FOR_TEST.mkdir());

        for (String s : FILES_FOR_TEST) {
            assertTrue(new File(DIR_FOR_TEST.getName() + '/' + s).createNewFile());
        }

        try {
            NIODemo.changeFilesExtension(DIR_FOR_TEST, OLD_EXTENSION, NEW_EXTENSION);

            files = DIR_FOR_TEST.listFiles();

            assertNotNull(files);

            for (File f : files) {
                assertFalse(f.getName().endsWith(OLD_EXTENSION));
            }
        } finally {
            if (files != null) {
                for (File f : files) {
                    Files.deleteIfExists(f.toPath());
                }
            }

            Files.deleteIfExists(DIR_FOR_TEST.toPath());
        }
    }
}