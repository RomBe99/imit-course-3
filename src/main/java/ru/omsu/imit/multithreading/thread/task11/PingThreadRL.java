package ru.omsu.imit.multithreading.thread.task11;

public class PingThreadRL extends Thread {
    private GameRL game;

    public PingThreadRL(GameRL game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.ping();
        }
    }
}