package ru.omsu.imit.multithreading.task7;

public class PingThread extends Thread {
    private Game game;

    public PingThread(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.ping();
        }
    }
}