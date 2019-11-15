package ru.omsu.imit.multithreading.thread.task5;

import java.util.ArrayList;

public class ArrayListOperations {
    private ArrayList<Integer> list;
    private int size;

    public ArrayListOperations(ArrayList<Integer> list, int size) {
        this.list = list;
        this.size = size;
    }

    public synchronized void fillRandomNumbers() {
        for (int i = 0; i <= size; i++) {
            list.add(i, (int) (Math.random() * size));
        }
    }

    public synchronized void removeAllElements() {
        while (!list.isEmpty()) {
            list.remove((int) (Math.random() * (list.size() - 1)));
        }
    }
}