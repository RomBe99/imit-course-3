package ru.omsu.imit.nio;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Objects;

public class NIODemo {
    private NIODemo() {
    }

    public static int[] writeAndReadNumbersFromFile(final File file) throws IOException {
        final int ARRAY_SIZE = 100;
        int[] intsForWrite = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            intsForWrite[i] = i;
        }

        try (FileChannel fc = new RandomAccessFile(file, "rw").getChannel()) {

            final int BUFFER_SIZE = Integer.BYTES * ARRAY_SIZE;

            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, BUFFER_SIZE);

            for (int i : intsForWrite) {
                mbb.putInt(i);
            }

            fc.write(mbb.flip());
        }

        int[] result = new int[ARRAY_SIZE];

        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                result[i] = dis.readInt();
            }
        }

        return result;
    }

    public static void changeFilesExtension(final File dir, final String oldExtension, final String newExtension) {
        if (dir != null && dir.exists() && dir.isDirectory()) {
            Arrays
                    .stream(Objects.requireNonNull(dir.listFiles(f -> f.getName().endsWith(oldExtension))))
                    .forEach(f -> f.renameTo(new File(dir.getName() + '/' + f.getName().replace(oldExtension, newExtension))));
        }
    }
}