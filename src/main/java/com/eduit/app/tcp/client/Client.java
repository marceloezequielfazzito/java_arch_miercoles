package com.eduit.app.tcp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public void connect() throws IOException {
        Socket socket = new Socket("127.0.0.1", 5500);
        System.out.println(" log : client connected ");
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        readData(bufferedReader);
        socket.close();
        System.out.println(" log : client disconnected ");
    }


    private void readData(BufferedReader bufferedReader) throws IOException {
        String line = "";
        while ((line = bufferedReader.readLine()) != null){
            System.out.println( "data receive " + line );
        }
        bufferedReader.close();
    }


}
