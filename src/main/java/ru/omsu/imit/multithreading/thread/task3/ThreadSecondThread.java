package ru.omsu.imit.multithreading.thread.task3;

public class ThreadSecondThread extends Thread {
    public ThreadSecondThread(final String name) {
        super(name);
    }

    @Override
    public void run() {
        final long SLEEP_TIME = 2000;

        System.out.printf("Run thread %s\n", this.getName());

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Finish thread %s\n", this.getName());
    }
}