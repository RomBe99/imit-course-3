package ru.omsu.imit.multithreading;

import ru.omsu.imit.multithreading.thread.task3.ThreadFirstThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadSecondThread;
import ru.omsu.imit.multithreading.thread.task3.ThreadThirdThread;
import ru.omsu.imit.multithreading.thread.task4.ThreadForAdd;
import ru.omsu.imit.multithreading.thread.task4.ThreadForRemove;
import ru.omsu.imit.multithreading.thread.task5.ArrayListOperations;
import ru.omsu.imit.multithreading.thread.task5.ThreadForArrayListOperations;

import java.util.ArrayList;

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
        final int SIZE = 10000;

        ArrayList<Integer> list = new ArrayList<>(SIZE);
        ThreadForAdd threadForAdd = new ThreadForAdd(list, SIZE);
        ThreadForRemove threadForRemove = new ThreadForRemove(list);

        threadForAdd.start();
        threadForRemove.start();
    }

    public static void task5() {
        final int SIZE = 10000;

        ArrayList<Integer> list = new ArrayList<>(SIZE);
        Thread t = new ThreadForArrayListOperations(new ArrayListOperations(list, SIZE));

        t.start();
    }
}