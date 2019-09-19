package ru.omsu.imit.nio.trainee;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

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
}