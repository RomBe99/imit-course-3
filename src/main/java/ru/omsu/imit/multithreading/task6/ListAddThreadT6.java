package ru.omsu.imit.multithreading.task6;

public class ListAddThreadT6 extends Thread {
    private ListProcessor processor;
    private int iterations;

    public ListAddThreadT6(ListProcessor processor, int iterations) {
        this.processor = processor;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            processor.addRandomElem();
        }
    }
}