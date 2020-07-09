package com.eduit.app;

import java.util.ArrayList;
import java.util.List;

public class MyFuture {


    private List<String> data;
    private Thread thread;


    public MyFuture(int times) {
        data = new ArrayList<>();
        thread = new Thread(() -> {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < times; i++) {
                data.add(name + " " + i);
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
