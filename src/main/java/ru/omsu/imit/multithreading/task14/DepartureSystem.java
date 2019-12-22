package ru.omsu.imit.multithreading.task14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DepartureSystem {

    private List<Message> messageList;

    public DepartureSystem() {
        messageList = new ArrayList<>();
    }

    private void letterMessage() {
        File mails = new File("./src/main/java/ru/omsu/imit/multithreading/task14/mail");

        try(BufferedReader reader = new BufferedReader(new FileReader(mails))) {
            String mailAddress = reader.readLine();

            while (mailAddress != null) {
                System.out.println(mailAddress);
                messageList.add(new Message(mailAddress,"me","Thread","Text"));
                mailAddress = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mailing() {
        letterMessage();
        ExecutorService pool = Executors.newFixedThreadPool(messageList.size());

        for (Message message: messageList) {
            pool.execute(new SendThread(message));
        }

        pool.shutdown();
    }
}
