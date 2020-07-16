package com.eduit.app.udpmulticast.client;

public class App {

    public static void main(String[] args) {



        for (int i = 0 ; i < 10 ; i++){
            final String clientName  = "client:"+i;
            new  Thread (()->{
                UDPMulticastClient  multicastClient = new UDPMulticastClient("235.1.1.1",4000 , clientName);
                multicastClient.receiveMulticastData();
            }).start();
        }







    }
}
