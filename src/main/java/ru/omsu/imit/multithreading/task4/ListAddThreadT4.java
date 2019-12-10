package ru.omsu.imit.multithreading.task4;

import java.util.List;

public class ListAddThreadT4 extends Thread {
    private List<Integer> list;

    public ListAddThreadT4(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int n;

        while (true) {
            synchronized (list) {
                if (!list.isEmpty()) {
                    continue;
                }

                n = (int) (Math.random() * 10);

                for (int i = 0; i < 10; i++) {
                    list.add(n);
                    System.out.println(n);
                }
            }
        }
    }
}