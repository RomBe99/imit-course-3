package ru.omsu.imit.multithreading.thread.task7;

import java.util.concurrent.Semaphore;

public class ThreadPong extends Thread {
    private Semaphore available;

    public ThreadPong(Semaphore available) {
        this.available = available;
    }

    @Override
    public void run() {
        try {
            available.acquire();
            System.out.println("Pong");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        available.release();
    }
}