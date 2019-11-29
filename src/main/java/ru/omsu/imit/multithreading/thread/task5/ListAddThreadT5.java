package ru.omsu.imit.multithreading.thread.task5;

public class ListAddThreadT5 extends Thread {
    private ListSyncProcessor processor;

    public ListAddThreadT5(ListSyncProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run(){
        while (true) {
            processor.addRandomElem();
        }
    }
}