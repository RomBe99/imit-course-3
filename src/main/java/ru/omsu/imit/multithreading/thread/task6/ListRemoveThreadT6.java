package ru.omsu.imit.multithreading.thread.task6;

public class ListRemoveThreadT6 extends Thread {
    private ListProcessor processor;

    public ListRemoveThreadT6(ListProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        while (true) {
            processor.removeRandomElement();
        }
    }
}