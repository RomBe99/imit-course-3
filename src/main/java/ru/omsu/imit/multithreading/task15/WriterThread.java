package ru.omsu.imit.multithreading.task15;

import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {
    private BlockingQueue<Data> dataQueue;
    private int count;

    public WriterThread(BlockingQueue<Data> dataQueue, int count) {
        this.dataQueue = dataQueue;
        this.count = count;
    }

    @Override
    public void run() {
        int size = (int) (Math.random() * 5) + 1;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000) - 100;
        }
        try {
            for (int i = 0; i < count; i++) {
                dataQueue.add(new Data(arr));
            }
            sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
