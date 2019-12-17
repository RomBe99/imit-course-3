package ru.omsu.imit.multithreading.task13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatterThread extends Thread {
    private Date date;
    private Formatter formatter;

    public FormatterThread(Date date, Formatter formatter) {
        this.date = date;
        this.formatter = formatter;
    }

    @Override
    public void run() {
        Formatter.setDateFormat(new SimpleDateFormat());
        System.out.println("date: " + formatter.formatDate(date));
    }
}