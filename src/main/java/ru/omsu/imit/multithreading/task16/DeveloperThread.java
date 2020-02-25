package ru.omsu.imit.multithreading.task16;

import java.util.concurrent.BlockingQueue;

public class DeveloperThread extends Thread {
    private BlockingQueue<Task> queue;
    private int count;

    public DeveloperThread(BlockingQueue<Task> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            queue.add(new Task("Task " + i));

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}