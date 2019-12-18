package ru.omsu.imit.multithreading.task12;

public class MapAddThread extends Thread {
    private ConcurrentHashMap<Integer, String> map;

    public MapAddThread(ConcurrentHashMap<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Add: " + "String" + i);
            this.map.put(i, "String " + i);
        }
    }
}