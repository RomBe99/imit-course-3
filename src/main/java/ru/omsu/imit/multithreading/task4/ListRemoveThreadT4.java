package ru.omsu.imit.multithreading.task4;

import java.util.List;

public class ListRemoveThreadT4 extends Thread {
    private List<Integer> list;

    public ListRemoveThreadT4(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        int n;

        while (true) {
            synchronized (list) {
                for (int i = 0; !list.isEmpty(); i++) {
                    n = (int) (Math.random() * (10 - i));
                    System.out.println("Item numbered " + n);
                    list.remove(n);
                }
            }
        }
    }
}