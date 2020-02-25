package ru.omsu.imit.multithreading.task16;

import java.util.concurrent.BlockingQueue;

public class ExecutorThread extends Thread {
    private BlockingQueue<Task> queue;

    public ExecutorThread(BlockingQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Task task;

        while (true) {
            if (!queue.isEmpty()) {
                task = queue.poll();

                if (task.getName() == null) {
                    break;
                }

                task.execute();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}