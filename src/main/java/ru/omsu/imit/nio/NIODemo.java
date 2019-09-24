package ru.omsu.imit.nio;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;

public class NIODemo {
    private NIODemo() {
    }

    public static int[] writeAndReadNumbersFromFile(final File file) throws IOException {
        final int ARRAY_SIZE = 100;
        int[] intsForWrite = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            intsForWrite[i] = i;
        }

        try (FileChannel fc = FileChannel.open(file.toPath(),
                file.exists() ? StandardOpenOption.WRITE : StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {

            final int BUFFER_SIZE = Integer.SIZE / 8 * ARRAY_SIZE;

            ByteBuffer mbb = MappedByteBuffer.allocate(BUFFER_SIZE);

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
}