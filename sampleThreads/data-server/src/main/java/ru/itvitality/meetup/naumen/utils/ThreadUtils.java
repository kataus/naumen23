package ru.itvitality.meetup.naumen.utils;

public class ThreadUtils {

    public static void sleep(Long time){
        try {
            Thread.sleep( time );
        } catch ( InterruptedException e ) {

        }
    }
}
