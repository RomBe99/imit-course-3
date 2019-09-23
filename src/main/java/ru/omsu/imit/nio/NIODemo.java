package ru.omsu.imit.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class NIODemo {
    private NIODemo() {
    }

    // TODO Не уверен, что чтение из файла реализованно как задумывалось, однако оно работает корректно
    public static int[] writeAndReadNumbersFromFile(final File file) throws IOException {
        final int SIZE = 100;
        int[] intsForWrite = new int[SIZE];

        for (int i = 0; i < SIZE; i++) {
            intsForWrite[i] = i;
        }

        try (FileChannel fc = (FileChannel) Files.newByteChannel(file.toPath(),
                file.exists() ? StandardOpenOption.WRITE : StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
            StringBuilder sb = new StringBuilder();

            for (int i : intsForWrite) {
                sb.append(i).append(" ");
            }

            fc.write(MappedByteBuffer.wrap(sb.toString().getBytes()));
        }

        int[] result = new int[SIZE];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String[] data = br.readLine().split(" ");

            for (int i = 0; i < SIZE; i++) {
                result[i] = Integer.parseInt(data[i]);
            }
        }

        return result;
    }
}