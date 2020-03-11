package ru.omsu.imit.multithreading.task17;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Runner {
    public static void main(String[] args) {
        final int taskCount = 7;
        BlockingQueue<Task> tasks = new ArrayBlockingQueue<>(2);
        BlockingQueue<TaskState> stages = new LinkedBlockingQueue<>();

        List<Thread> developers = Arrays.asList(
                new DeveloperThread(tasks, stages, 5),
                new DeveloperThread(tasks, stages, 1),
                new DeveloperThread(tasks, stages, 1)
        );
        List<Thread> executors = Arrays.asList(
                new ExecutorThread(tasks, stages),
                new ExecutorThread(tasks, stages)
        );

        for (Thread developer : developers) {
            developer.start();
        }

        for (Thread executor : executors) {
            executor.start();
        }

        try {
            for (Thread developer : developers) {
                developer.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int completedTasks = 1; completedTasks <= taskCount;) {
            try {
                if (stages.take().equals(TaskState.EXECUTOR_COMPLETE_TASK)) {
                    completedTasks++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < executors.size(); i++) {
            tasks.add(Task.poison);
        }

        try {
            for (Thread executor : executors) {
                executor.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}