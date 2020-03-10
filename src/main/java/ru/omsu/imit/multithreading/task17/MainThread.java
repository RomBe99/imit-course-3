package ru.omsu.imit.multithreading.task17;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MainThread {
    public static void main(String[] args) {
        BlockingQueue<Task> queue = new LinkedBlockingQueue<>();
        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

        int count_dev = 1;
        int finished_dev = 0;
        int count_task = 4;
        int task_end = 0;

        Thread developer1 = new DeveloperThread(queue, eventQueue);
        Thread executor = new ExecutorThread(queue, eventQueue);
        Thread developer2 = new DeveloperThread(queue, eventQueue);

        Event event;

        developer1.start();
//        developer2.start();
        executor.start();

        do {
            event = null;

            try {
                event = eventQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (event == Event.WRITER_ENDED) {
                finished_dev++;
            }

            if (event == Event.TASK_ENDED) {
                task_end++;
            }

        } while (finished_dev != count_dev || task_end != count_task);

        try {
            developer1.join();
//            developer2.join();

            executor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}