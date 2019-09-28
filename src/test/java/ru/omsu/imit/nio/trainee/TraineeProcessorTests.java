package ru.omsu.imit.nio.trainee;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TraineeProcessorTests extends Assert {
    @Test
    public void writeTraineeToFileWithByteBufferTest1() throws TraineeException, IOException {
        final File FILE_FOR_TEST = new File("trainee.txt");
        final Trainee TRAINEE_FOR_TEST = new Trainee("FirstName", "LastName", 1);

        TraineeProcessor.writeTraineeToFileWithByteBuffer(FILE_FOR_TEST, TRAINEE_FOR_TEST);

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_FOR_TEST))) {
            final String[] DATA = br.readLine().split(" ");
            final Trainee ACTUAL = new Trainee(DATA[0], DATA[1], Integer.parseInt(DATA[2]));

            assertEquals(TRAINEE_FOR_TEST, ACTUAL);
        } finally {
            if (FILE_FOR_TEST.exists()) {
                assertTrue(FILE_FOR_TEST.delete());
            }
        }
    }

    @Test
    public void readTraineeFromTextFileWithByteBufferTest1() throws IOException, TraineeException {
        final File FILE_FOR_READ = new File("trainee.txt");

        assertTrue(FILE_FOR_READ.createNewFile());

        try {
            final Trainee ACTUAL = TraineeProcessor.readTraineeFromTextFileWithByteBuffer(FILE_FOR_READ);

            assertNull(ACTUAL);
        } finally {
            if (FILE_FOR_READ.exists()) {
                assertTrue(FILE_FOR_READ.delete());
            }
        }
    }

    @Test
    public void readTraineeFromTextFileWithByteBufferTest2() throws IOException, TraineeException {
        final File FILE_FOR_TEST = new File("trainee.txt");
        final Trainee TRAINEE_FOR_TEST = new Trainee("FirstName", "LastName", 1);

        TraineeProcessor.writeTraineeToTextFileOneLine(FILE_FOR_TEST, TRAINEE_FOR_TEST);

        try {
            final Trainee ACTUAL = TraineeProcessor.readTraineeFromTextFileWithByteBuffer(FILE_FOR_TEST);

            assertEquals(TRAINEE_FOR_TEST, ACTUAL);
        } finally {
            if (FILE_FOR_TEST.exists()) {
                assertTrue(FILE_FOR_TEST.delete());
            }
        }
    }

    @Test
    public void readTraineeFromTextFileWithMappedByteBufferTest1() throws IOException, TraineeException {
        final File FILE_FOR_READ = new File("trainee.txt");

        assertTrue(FILE_FOR_READ.createNewFile());

        try {
            final Trainee ACTUAL = TraineeProcessor.readTraineeFromTextFileWithMappedByteBuffer(FILE_FOR_READ);

            assertNull(ACTUAL);
        } finally {
            if (FILE_FOR_READ.exists()) {
                assertTrue(FILE_FOR_READ.delete());
            }
        }
    }

    @Test
    public void readTraineeFromTextFileWithMappedByteBufferTest2() throws IOException, TraineeException {
        final File FILE_FOR_TEST = new File("trainee.txt");
        final Trainee TRAINEE_FOR_TEST = new Trainee("FirstName", "LastName", 1);

        TraineeProcessor.writeTraineeToTextFileOneLine(FILE_FOR_TEST, TRAINEE_FOR_TEST);

        try {
            final Trainee ACTUAL = TraineeProcessor.readTraineeFromTextFileWithMappedByteBuffer(FILE_FOR_TEST);

            assertEquals(TRAINEE_FOR_TEST, ACTUAL);
        } finally {
            if (FILE_FOR_TEST.exists()) {
                assertTrue(FILE_FOR_TEST.delete());
            }
        }
    }
}