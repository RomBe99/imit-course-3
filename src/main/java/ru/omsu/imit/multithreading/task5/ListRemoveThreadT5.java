package ru.omsu.imit.multithreading.task5;

public class ListRemoveThreadT5 extends Thread {
    private ListSyncProcessor processor;

    public ListRemoveThreadT5(ListSyncProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run(){
        while (true) {
            processor.removeRandomElement();
        }
    }
}