package ru.omsu.imit.multithreading.task8;

public class WriterThread extends Thread {
    private Book book;

    public WriterThread(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        while(true) {
            book.write();
        }
    }
}