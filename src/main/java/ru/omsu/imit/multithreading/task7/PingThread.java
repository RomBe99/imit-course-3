package ru.omsu.imit.multithreading.task7;

public class PingThread extends Thread {
    private Game game;
    private int iterations;

    public PingThread(Game game, int iterations) {
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