package ru.omsu.imit.multithreading.task17;

import java.util.concurrent.BlockingQueue;

public class ExecutorThread extends Thread {
    private BlockingQueue<Task> tasks;
    private BlockingQueue<TaskState> states;

    public ExecutorThread(BlockingQueue<Task> tasks, BlockingQueue<TaskState> states) {
        this.tasks = tasks;
        this.states = states;
    }

    @Override
    public void run() {
        Task task;

        while (true) {
            try {
                task = tasks.take();

                if (Task.poison.equals(task)) {
                    break;
                }

                System.out.println("Executor(" + getId() + ") " + "read");

                if (!task.getStages().isEmpty()) {
                    task.getStages().get(0).execute();
                    task.getStages().remove(0);

                    tasks.put(task);
                    states.put(TaskState.EXECUTOR_START_TASK);
                } else {
                    states.put(TaskState.EXECUTOR_COMPLETE_TASK);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Executor(" + getId() + ") " + "finished");
    }
}