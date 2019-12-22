package ru.omsu.imit.multithreading.task14;

public class SendThread extends Thread {
    private Message  message;

    public SendThread(Message message) {
        this.message = message;
    }

    @Override
    public void run(){
        new Transport().send(message);
    }
}