package com.eduit.app.udp.server;

public class App {

    public static void main(String[] args) {

        UDPServer udpServer = new UDPServer("localhost",5000);
        udpServer.sendDataTo("localhost",4000);


    }
}
