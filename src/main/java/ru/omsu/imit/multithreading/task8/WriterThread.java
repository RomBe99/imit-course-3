package ru.omsu.imit.multithreading.task8;

public class WriterThread extends Thread {
    private Book book;
    private int iterations;

    public WriterThread(Book book, int iterations) {
        this.book = book;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            book.write();
        }
    }
}