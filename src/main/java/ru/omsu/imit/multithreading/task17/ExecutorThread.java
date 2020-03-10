package ru.omsu.imit.multithreading.task17;

import java.util.concurrent.BlockingQueue;

public class ExecutorThread extends Thread {
    private BlockingQueue<Task> queue;
    private BlockingQueue<Event> eventQueue;

    public ExecutorThread(BlockingQueue<Task> queue, BlockingQueue<Event> eventQueue) {
        this.queue = queue;
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = queue.take();
                task.execute();

                if (!task.isEnd()) {
                    queue.put(task);
                    continue;
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }

            try {
                eventQueue.put(Event.TASK_ENDED);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}