package ru.omsu.imit.multithreading.thread.task5;

public class ThreadForArrayListOperations extends Thread{
    private ArrayListOperations operations;

    public ThreadForArrayListOperations(ArrayListOperations operations) {
        this.operations = operations;
    }

    @Override
    public void run() {
        operations.fillRandomNumbers();
        operations.removeAllElements();
    }
}