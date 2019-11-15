package ru.omsu.imit.multithreading.thread.task6;

import java.util.ArrayList;

public class ThreadForClear extends Thread {
    private ArrayList<Integer> list;

    public ThreadForClear(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (!list.isEmpty()) {
            list.remove((int) (Math.random() * (list.size() - 1)));
        }
    }
}