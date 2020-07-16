package com.eduit.app.udpmulticast.server;

public class App {


    public static void main(String[] args) {
        UDPMulticastServer udpMulticastServer = new UDPMulticastServer();
        udpMulticastServer.sendMulticastData();
    }

}
