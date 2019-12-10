package ru.omsu.imit.multithreading.task3;

public class ThreadThirdThread extends Thread {
    public ThreadThirdThread(final String name) {
        super(name);
    }

    @Override
    public void run() {
        final long SLEEP_TIME = 3000;

        System.out.printf("Run thread %s\n", this.getName());

        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Finish thread %s\n", this.getName());
    }
}