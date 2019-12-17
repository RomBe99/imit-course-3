package ru.omsu.imit.multithreading.task5;

import java.util.List;

public class ListSyncProcessor {
    private List<Integer> list;

    public ListSyncProcessor(List<Integer> list) {
        this.list = list;
    }

    public synchronized void removeRandomElement() {
        if (list.isEmpty()) {
            return;
        }

        int n = (int) (Math.random() * list.size());
        System.out.println("Item numbered " + n);
        list.remove(n);
    }

    public synchronized void addRandomElem(){
        int n = (int) (Math.random() * 10);

        list.add(n);
        System.out.println(n);
    }
}