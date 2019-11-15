package ru.omsu.imit.multithreading.thread.task4;

import java.util.ArrayList;

public class ThreadForRemove extends Thread {
    private final ArrayList<Integer> list;

    public ThreadForRemove(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list) {
            while (!list.isEmpty()) {
                list.remove((int) (Math.random() * (list.size() - 1)));
            }
        }
    }
}