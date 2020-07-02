package com.eduit.app;

import java.util.ArrayList;
import java.util.List;

public class MyFuture {

    private List<String> data;
    private Thread thread;

    public MyFuture() {
        data = new ArrayList<>();
        thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String tName = Thread.currentThread().getName();
                data.add(tName + " " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    public List<String> get() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }

}
