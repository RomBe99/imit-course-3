package ru.omsu.imit.multithreading.task13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    private static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<>();

    public static void setDateFormat(SimpleDateFormat simpleDateFormat) {
        dateFormatThreadLocal.set(simpleDateFormat);
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormatThreadLocal.get();
    }

    public String formatDate(Date date) {
        return getDateFormat().format(date);
    }
}