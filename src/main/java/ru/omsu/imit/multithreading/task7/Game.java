package ru.omsu.imit.multithreading.task7;

import java.util.concurrent.Semaphore;

public class Game {
    private static Semaphore semPong = new Semaphore(0);
    private static Semaphore semPing = new Semaphore(1);

    public void ping() {
        try{
            semPing.acquire();
            System.out.println("Ping ");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semPong.release();
        }
    }

    public void pong() {
        try{
            semPong.acquire();
            System.out.println("Pong ");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        } finally {
            semPing.release();
        }
    }
}