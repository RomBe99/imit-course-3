package ru.omsu.imit.multithreading.task4;

import java.util.List;

public class ListAddThreadT4 extends Thread {
    private final List<Integer> list;
    private int iterations;

    public ListAddThreadT4(List<Integer> list, int iterations) {
        this.list = list;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        int n;

        for (int i = 0; i < iterations; i++) {
            synchronized (list) {
                if (!list.isEmpty()) {
                    continue;
                }

                n = (int) (Math.random() * 10);

                for (int j = 0; j < 10; j++) {
                    list.add(n);
                    System.out.println(n);
                }
            }
        }
    }
}