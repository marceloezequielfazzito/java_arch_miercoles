package com.eduit.app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {

    private final ThreadPoolExecutor threadPool;
    private ServerSocket serverSocket;

    public Server(int corePoolSize , int port) throws IOException {
        serverSocket = new ServerSocket(port);
        threadPool = new ThreadPoolExecutor(corePoolSize,
                corePoolSize,
                1, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());

    }

    public void start(){
        while(true) {
            System.out.println(" waiting client");
            Socket accept = null;
            try {
                accept = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.println("client connected" + accept.getInetAddress());

            Client client = new Client(accept);
            threadPool.execute(()->{
                try {
                    client.serve();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            });


        }


        }

}
