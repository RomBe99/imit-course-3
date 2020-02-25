package ru.omsu.imit.multithreading.task15;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {
    private BlockingQueue<Data> dataQueue;

    public ReaderThread(BlockingQueue<Data> dataQueue) {
        this.dataQueue = dataQueue;
    }

    @Override
    public void run() {
        Data data;

        while (true) {
            try {
                data = dataQueue.take();
                System.out.println(Arrays.toString(data.get()));

                if (data.get() == null) {
                    System.out.println(" finished");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}