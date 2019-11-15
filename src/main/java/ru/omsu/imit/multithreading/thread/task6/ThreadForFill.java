package ru.omsu.imit.multithreading.thread.task6;

import java.util.ArrayList;

public class ThreadForFill extends Thread {
    private ArrayList<Integer> list;
    private int size;

    public ThreadForFill(ArrayList<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    @Override
    public void run() {
        for (int i = 0; i <= size; i++) {
            list.add(i, (int) (Math.random() * size));
        }
    }
}