package ru.omsu.imit.multithreading.task15;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    public static void main(String[] args) {
        int count = 10;
        BlockingQueue<Data> queue = new LinkedBlockingQueue<>();

        Thread writer1 = new WriterThread(queue, count);
        Thread reader = new ReaderThread(queue);
        Thread writer2 = new WriterThread(queue, count);

        writer1.start();
        reader.start();
        writer2.start();

        try {
            writer1.join();
            writer2.join();
            queue.add(new Data(null));
            reader.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}