package ru.omsu.imit.multithreading.task11;

public class PingThreadRL extends Thread {
    private GameRL game;
    private int iterations;

    public PingThreadRL(GameRL game, int iterations) {
        this.game = game;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            game.ping();
        }
    }
}