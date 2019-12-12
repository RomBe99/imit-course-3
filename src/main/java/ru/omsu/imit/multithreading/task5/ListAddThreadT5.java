package ru.omsu.imit.multithreading.task5;

public class ListAddThreadT5 extends Thread {
    private ListSyncProcessor processor;
    private int iterations;

    public ListAddThreadT5(ListSyncProcessor processor, int iterations) {
        this.processor = processor;
        this.iterations = iterations;
    }

    @Override
    public void run(){
        for (int i = 0; i < iterations; i++) {
            processor.addRandomElem();
        }
    }
}