package com.eduit.app.tcp.client;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        for (int i = 0 ; i < 50 ; i++){
            new Thread(()->{
                Client client = new Client();
                try {
                    client.connect();
                } catch (IOException e) {
                   throw new RuntimeException(e);
                }
            }).start();
        }

    }


}
