package ru.omsu.imit.multithreading.task6;

import java.util.List;

public class ListProcessor {
    private List<Integer> list;

    public ListProcessor(List<Integer> list) {
        this.list = list;
    }

    public void removeRandomElement() {
        if (list.isEmpty()) {
            return;
        }

        int n = (int) (Math.random() * list.size());
        System.out.println("item numbered " + n);
        list.remove(n);
    }

    public void addRandomElem(){
        int n = (int) (Math.random() * 10);

        list.add(n);
        System.out.println(n);
    }
}
