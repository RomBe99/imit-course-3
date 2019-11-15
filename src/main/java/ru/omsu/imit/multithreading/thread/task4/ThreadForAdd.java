package ru.omsu.imit.multithreading.thread.task4;

import java.util.ArrayList;

public class ThreadForAdd extends Thread {
    private final ArrayList<Integer> list;
    private final int size;

    public ThreadForAdd(ArrayList<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public void run() {
        synchronized (list) {
            for (int i = 0; i <= size; i++) {
                list.add(i, (int) (Math.random() * size));
            }
        }
    }
}