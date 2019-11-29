package ru.omsu.imit.multithreading;

import ru.omsu.imit.multithreading.thread.task3.ThreadFirstThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadSecondThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadThirdThread;

public class MultithreadingDemo {
    public static void printAllCurrentThreadProperties() {
        Thread currentThread = Thread.currentThread();

        System.out.println(currentThread.getName());
        System.out.println(currentThread.getId());
        System.out.println(currentThread.getPriority());
        System.out.println(currentThread.getState());
        System.out.println(currentThread.getThreadGroup());
    }

    public static void startThreeThreads() {
        Thread t1 = new ThreadFirstThread("First thread");
        Thread t2 = new ThreadSecondThread("Second thread");
        Thread t3 = new ThreadThirdThread("Third thread");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}