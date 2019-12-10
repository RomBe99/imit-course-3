package ru.omsu.imit.multithreading.task7;

public class PongThread extends Thread {
    private Game game;

    public PongThread(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.pong();
        }
    }
}