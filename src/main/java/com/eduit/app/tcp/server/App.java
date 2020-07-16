package com.eduit.app.tcp.server;

import java.io.IOException;

public class App {


    public static void main(String[] args) throws IOException {


        Server server = new Server(25,5500);

        server.start();


    }


}
