package ru.omsu.imit.multithreading.task11;

public class PongThreadRL extends Thread {
    private GameRL game;

    public PongThreadRL(GameRL game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.pong();
        }
    }
}