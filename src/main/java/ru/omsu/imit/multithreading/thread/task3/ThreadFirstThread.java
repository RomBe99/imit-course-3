package ru.omsu.imit.multithreading.thread.task3;

public class ThreadFirstThread extends Thread {
    public ThreadFirstThread(final String name) {
        super(name);
    }

    @Override
    public void run() {
        final long SLEEP_TIME = 1000;

        System.out.printf("Run thread %s\n", this.getName());

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Finish thread %s\n", this.getName());
    }
}