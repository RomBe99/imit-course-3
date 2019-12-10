package ru.omsu.imit.multithreading;

import ru.omsu.imit.multithreading.task11.GameRL;
import ru.omsu.imit.multithreading.task11.PingThreadRL;
import ru.omsu.imit.multithreading.task11.PongThreadRL;
import ru.omsu.imit.multithreading.task3.ThreadFirstThread;
import ru.omsu.imit.multithreading.task3.ThreadSecondThread;
import ru.omsu.imit.multithreading.task3.ThreadThirdThread;
import ru.omsu.imit.multithreading.task4.ListAddThreadT4;
import ru.omsu.imit.multithreading.task4.ListRemoveThreadT4;
import ru.omsu.imit.multithreading.task5.ListAddThreadT5;
import ru.omsu.imit.multithreading.task5.ListRemoveThreadT5;
import ru.omsu.imit.multithreading.task5.ListSyncProcessor;
import ru.omsu.imit.multithreading.task6.ListAddThreadT6;
import ru.omsu.imit.multithreading.task6.ListProcessor;
import ru.omsu.imit.multithreading.task6.ListRemoveThreadT6;
import ru.omsu.imit.multithreading.task7.Game;
import ru.omsu.imit.multithreading.task7.PingThread;
import ru.omsu.imit.multithreading.task7.PongThread;
import ru.omsu.imit.multithreading.task8.Book;
import ru.omsu.imit.multithreading.task8.ReaderThread;
import ru.omsu.imit.multithreading.task8.WriterThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultithreadingDemo {
    public static void printAllCurrentThreadProperties() {
        Thread currentThread = Thread.currentThread();

        System.out.println(currentThread.getName());
        System.out.println(currentThread.getId());
        System.out.println(currentThread.getPriority());
        System.out.println(currentThread.getState());
        System.out.println(currentThread.getThreadGroup());
    }

    public static void startThreeThreads() {
        Thread t1 = new ThreadFirstThread("First thread");
        Thread t2 = new ThreadSecondThread("Second thread");
        Thread t3 = new ThreadThirdThread("Third thread");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task4() {
        List<Integer> list = new ArrayList<>();
        Thread t1 = new ListRemoveThreadT4(list);
        Thread t2 = new ListAddThreadT4(list);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task5() {
        ListSyncProcessor processor = new ListSyncProcessor(new ArrayList<>());

        Thread t1 = new ListRemoveThreadT5(processor);
        Thread t2 = new ListAddThreadT5(processor);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task6() {
        ListProcessor processor = new ListProcessor(Collections.synchronizedList(new ArrayList<>()));

        Thread t1 = new ListRemoveThreadT6(processor);
        Thread t2 = new ListAddThreadT6(processor);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task7() {
        Game game = new Game();

        Thread ping = new PingThread(game);
        Thread pong = new PongThread(game);

        ping.start();
        pong.start();

        try {
            ping.join();
            pong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task8() {
        Book book = new Book();

        ReaderThread reader = new ReaderThread(book);
        WriterThread writer = new WriterThread(book);

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void task11() {
        GameRL game = new GameRL();

        Thread ping = new PingThreadRL(game);
        Thread pong = new PongThreadRL(game);

        ping.start();
        pong.start();

        try {
            ping.join();
            pong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}