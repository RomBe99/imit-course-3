package ru.omsu.imit.multithreading.task17;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class DeveloperThread extends Thread {
    private BlockingQueue<Task> tasks;
    private BlockingQueue<TaskState> states;
    private int count;

    public DeveloperThread(BlockingQueue<Task> tasks, BlockingQueue<TaskState> states, int count) {
        this.tasks = tasks;
        this.states = states;
        this.count = count;
    }

    private Task addTask(int subjectCount, int stageCount) {
        Task task = new Task("Subject" + subjectCount, new ArrayList<>());
        int stageNumber;

        for (int i = 0; i < stageCount; i++) {
            stageNumber = (int) (Math.random() * 10);

            task.getStages().add(new Task("Stage №" + stageNumber, null));
        }

        return task;
    }

    @Override
    public void run() {
        int subjectCount;
        int stageCount;

        for (int i = 0; i < count; i++) {
            try {
                System.out.println("Developer(" + getId() + ")" + " add new task");

                subjectCount = (int) (Math.random() * 10);
                stageCount = (int) (Math.random() * 3);

                tasks.put(addTask(subjectCount, stageCount));
                states.put(TaskState.DEVELOPER_ADD_NEW_TASK);

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Developer(" + getId() + ") " + "finished");
    }
}