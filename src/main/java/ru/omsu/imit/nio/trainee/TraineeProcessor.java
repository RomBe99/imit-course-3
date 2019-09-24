package ru.omsu.imit.nio.trainee;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.StandardOpenOption;

public class TraineeProcessor {
    private TraineeProcessor() {
    }

    public static void writeTraineeToTextFileOneLine(final File file, final Trainee trainee) throws IOException {
        try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
            ps.print(trainee.getFirstName() + " ");
            ps.print(trainee.getLastName() + " ");
            ps.print(trainee.getMark());
        }
    }

    public static void writeTraineeToFileWithByteBuffer(final File file, final Trainee trainee) throws IOException {
        final char[] FIRST_NAME_CHARS = trainee.getFirstName().toCharArray();
        final char[] LAST_NAME_CHARS = trainee.getLastName().toCharArray();
        final int BUFFER_SIZE = FIRST_NAME_CHARS.length * Character.SIZE / 8 + LAST_NAME_CHARS.length * Character.SIZE / 8 + Integer.SIZE / 8;

        try (FileChannel fc = FileChannel.open(file.toPath(), StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
            ByteBuffer bb = ByteBuffer.allocate(BUFFER_SIZE);

            for (char c : FIRST_NAME_CHARS) {
                bb.putChar(c);
            }

            for (char c : LAST_NAME_CHARS) {
                bb.putChar(c);
            }

            bb.putInt(trainee.getMark());
            fc.write(bb.flip());
        }
    }

    public static Trainee readTraineeFromTextFileWithByteBuffer(final File file) throws IOException, TraineeException {
        if (file.length() == 0) {
            return null;
        }

        try (FileChannel fc = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            ByteBuffer bb = ByteBuffer.allocate((int) file.length());

            fc.read(bb);

            String[] data = new String(StandardCharsets.UTF_8.decode(bb.flip()).array()).split(" ");

            return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
        }
    }

    public static Trainee readTraineeFromTextFileWithMappedByteBuffer(final File file) throws IOException, TraineeException {
        if (file.length() == 0) {
            return null;
        }

        try (FileChannel fc = FileChannel.open(file.toPath(), StandardOpenOption.READ)) {
            ByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

            if (mbb != null) {
                String[] data = new String(StandardCharsets.UTF_8.decode(mbb).flip().array()).split(" ");

                return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
            }

            return null;
        }
    }
}