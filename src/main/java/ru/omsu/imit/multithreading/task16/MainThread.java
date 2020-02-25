package ru.omsu.imit.multithreading.task16;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    public static void main(String[] args) {
        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();

        Thread developer1 = new DeveloperThread(queue, 10);
        Thread executor = new ExecutorThread(queue);
        Thread developer2 = new DeveloperThread(queue, 10);

        developer1.start();
        executor.start();
        developer2.start();

        try {
            developer1.join();
            developer2.join();
            queue.add(new Task(null));
            executor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}