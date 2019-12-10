package ru.omsu.imit.multithreading.task6;

public class ListAddThreadT6 extends Thread {
    private ListProcessor processor;

    public ListAddThreadT6(ListProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        while (true) {
            processor.addRandomElem();
        }
    }
}