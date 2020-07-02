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

    public void serve(){
        try {
            System.out.println(" generating message");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(" message generated returning to client ");
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter =
                    new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(" bienvenido cliente");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }

    }

}
