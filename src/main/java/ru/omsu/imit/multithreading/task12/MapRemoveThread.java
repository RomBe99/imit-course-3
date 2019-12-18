package ru.omsu.imit.multithreading.task12;

public class MapRemoveThread extends Thread {
    private ConcurrentHashMap<Integer, String> map;

    public MapRemoveThread(ConcurrentHashMap<Integer, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Remove: " + this.map.remove(i));
        }
    }
}