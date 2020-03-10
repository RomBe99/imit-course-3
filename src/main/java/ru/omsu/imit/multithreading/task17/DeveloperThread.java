package ru.omsu.imit.multithreading.task17;

import ru.omsu.imit.multithreading.task16.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class DeveloperThread extends Thread {
    private BlockingQueue<Task> queue;
    private BlockingQueue<Event> eventQueue;

    public DeveloperThread(BlockingQueue<Task> queue, BlockingQueue<Event> eventQueue) {
        this.queue = queue;
        this.eventQueue = eventQueue;
    }

    @Override
    public void run() {
        List<Executable> list;
        int size;
        Task task;

        try {
            for (int i = 0; i < 5; i++) {
                list = new ArrayList<>();
                size = 5;

                for (int j = 0; j < size; j++) {
                    list.add(new Task(String.valueOf(getId()), j));
                }

                task = new Task(list);
                sleep(500);
                queue.put(task);
            }

            eventQueue.put(Event.WRITER_ENDED);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}