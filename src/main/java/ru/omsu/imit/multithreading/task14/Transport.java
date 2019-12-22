package ru.omsu.imit.multithreading.task14;

public class Transport extends Thread {
    public void send(Message message) {
        System.out.println("Send message: " + message.getSubject() + "; User: " + message.getEmailAddress());
    }
}