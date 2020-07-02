package com.eduit.app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private ExecutorService poolExecutor;
    private ServerSocket serverSocket;

    public Server(int maxConcurrency, int port) throws IOException {
        poolExecutor = Executors.newFixedThreadPool(maxConcurrency);
        serverSocket = new ServerSocket(port);
    }

    public void startServer(){
        System.out.println(" starting server port" + serverSocket.getLocalPort());
        while (true){
            try {
                System.out.println("waiting for client ");
                Socket accept = serverSocket.accept();
                System.out.println("client connected " + accept.getInetAddress());
                Client client = new Client(accept);
                poolExecutor.execute(()-> {
                    try {
                        client.serve();
                    }catch (RuntimeException e){
                        System.err.println(" could send message to client " + accept.getInetAddress());
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



}
