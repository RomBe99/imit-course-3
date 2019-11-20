package ru.omsu.imit.multithreading.thread.task7;

import java.util.concurrent.Semaphore;

public class ThreadPing extends Thread{
    private Semaphore available;

    public ThreadPing(Semaphore available) {
        this.available = available;
    }

    @Override
    public void run() {
        try {
            available.acquire();
            System.out.println("Ping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        available.release();
    }
}