package ru.omsu.imit.multithreading.task11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class GameRL {
    private int count = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void ping() {
        try {
            lock.lock();

            while (count % 2 == 0) {
                condition.await();
            }

            System.out.println("Ping");
            count++;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void pong() {
        try {
            lock.lock();

            while (count % 2 == 1) {
                condition.await();
            }

            System.out.println("Pong");
            count++;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}