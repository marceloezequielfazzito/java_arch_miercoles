package com.eduit.app.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App {


    public static void main(String[] args) throws IOException {


        Server server = new Server(10,5500);

        server.start();


    }


}
