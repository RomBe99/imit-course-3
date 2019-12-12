package ru.omsu.imit.multithreading.task11;

public class PongThreadRL extends Thread {
    private GameRL game;
    private int iterations;

    public PongThreadRL(GameRL game, int iterations) {
        this.game = game;
        this.iterations = iterations;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            game.pong();
        }
    }
}