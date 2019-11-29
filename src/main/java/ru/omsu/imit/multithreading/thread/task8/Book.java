package ru.omsu.imit.multithreading.thread.task8;

import java.util.concurrent.Semaphore;

public class Book {
    private static Semaphore writerSemaphore = new Semaphore(1);
    private static Semaphore readerSemaphore = new Semaphore(0);

    public void write() {
        try{
            writerSemaphore.acquire();
            System.out.println("Write book");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException ");
        } finally {
            readerSemaphore.release();
        }
    }

    public void read() {
        try{
            readerSemaphore.acquire();
            System.out.println("Read book");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException ");
        } finally {
            writerSemaphore.release();
        }
    }
}