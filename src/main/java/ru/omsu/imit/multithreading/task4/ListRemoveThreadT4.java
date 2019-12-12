package ru.omsu.imit.multithreading.task4;

import java.util.List;

public class ListRemoveThreadT4 extends Thread {
    private final List<Integer> list;
    private int iterations;

    public ListRemoveThreadT4(List<Integer> list, int iterations) {
        this.list = list;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int n;

        for (int i = 0; i < iterations; i++) {
            synchronized (list) {
                for (int j = 0; !list.isEmpty(); j++) {
                    n = (int) (Math.random() * (10 - j));
                    System.out.println("Item numbered " + n);
                    list.remove(n);
                }
            }
        }
    }
}