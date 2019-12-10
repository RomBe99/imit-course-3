package ru.omsu.imit.multithreading.task6;

import java.util.List;

public class ListProcessor {
    private List<Integer> list;

    public ListProcessor(List<Integer> list) {
        this.list = list;
    }

    public void removeRandomElement() {
        int n;

        for (int i = 0; !list.isEmpty(); i++) {
            n = (int) (Math.random() * (10 - i));
            System.out.println("item numbered " + n);
            list.remove(n);
        }
    }

    public void addRandomElem(){
        if(!list.isEmpty()) {
            return;
        }

        int n = (int) (Math.random() * 10);

        for (int i = 0; i < 10; i++) {
            list.add(n);
            System.out.println(n);
        }
    }
}
