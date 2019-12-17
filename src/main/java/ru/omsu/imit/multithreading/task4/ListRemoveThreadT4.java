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
                if (list.isEmpty()) {
                    continue;
                }

                n = (int) (Math.random() * list.size());
                System.out.println("Item numbered " + n);
                list.remove(n);
            }
        }
    }
}