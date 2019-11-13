package ru.omsu.imit.multithreading;

import ru.omsu.imit.multithreading.thread.task3.ThreadFirstThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadSecondThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadThirdThread;

import java.util.StringJoiner;

public class MultithreadingDemo {
    public static String printAllCurrentThreadProperties() {
        Thread currentThread = Thread.currentThread();

        StringJoiner sj = new StringJoiner("\n");
        sj.add(currentThread.getName());
        sj.add(String.valueOf(currentThread.getId()));
        sj.add(String.valueOf(currentThread.getPriority()));
        sj.add(String.valueOf(currentThread.getState()));
        sj.add(String.valueOf(currentThread.getThreadGroup()));

        return sj.toString();
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