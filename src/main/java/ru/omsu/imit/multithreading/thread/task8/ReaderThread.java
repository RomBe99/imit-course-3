package ru.omsu.imit.multithreading.thread.task8;

public class ReaderThread extends Thread {
    private Book book;

    public ReaderThread(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        while(true) {
            book.read();
        }
    }
}