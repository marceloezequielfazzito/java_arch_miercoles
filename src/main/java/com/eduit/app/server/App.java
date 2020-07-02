package com.eduit.app.server;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        Server server = new Server(2,9000);
        server.startServer();

    }


}
