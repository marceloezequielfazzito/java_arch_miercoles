package com.eduit.app.udp.client;

public class App {

    public static void main(String[] args) {

        UDPClient udpClient = new UDPClient("localhost",4000);
        udpClient.readFromDatagramSocket();


    }
}
