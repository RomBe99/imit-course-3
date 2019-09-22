package ru.omsu.imit.nio.trainee;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
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

    public static Trainee readTraineeFromTextFileWithByteBuffer(final File file) throws IOException, TraineeException {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(file.toPath(), StandardOpenOption.READ)) {
            if (fc.size() == 0) {
                return null;
            }

            ByteBuffer bb = ByteBuffer.allocate((int) fc.size());

            fc.read(bb);

            String[] data = new String(bb.array(), StandardCharsets.UTF_8).split(" ");

            return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
        }
    }

    public static Trainee readTraineeFromTextFileWithMappedByteBuffer(final File file) throws IOException, TraineeException {
        try (FileChannel fc = (FileChannel) Files.newByteChannel(file.toPath(), StandardOpenOption.READ)) {
            ByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

            if (mbb != null) {
                String[] data = new String(StandardCharsets.UTF_8.decode(mbb).array()).split(" ");

                return new Trainee(data[0], data[1], Integer.parseInt(data[2]));
            }

            return null;
        }
    }
}