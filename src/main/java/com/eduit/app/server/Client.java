package com.eduit.app.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    private Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void serve() throws IOException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(outputStream));
        bf.write(" datos .......");
        bf.close();
        socket.close();
    }
}
