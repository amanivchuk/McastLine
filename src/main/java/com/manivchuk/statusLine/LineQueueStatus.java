package com.manivchuk.statusLine;

import com.manivchuk.beans.StatusConnect;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Lenovo on 11.03.2017.
 */
public class LineQueueStatus {
    private static ConcurrentLinkedQueue<StatusConnect> queue = new ConcurrentLinkedQueue<>();

    public static void addLine(StatusConnect line){ queue.add(line); }
    public static StatusConnect getLine(){
        return queue.poll();
    }
    public static int size(){
        return queue.size();
    }

}
