package ru.omsu.imit.multithreading;

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
}