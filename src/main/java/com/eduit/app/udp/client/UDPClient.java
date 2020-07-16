package com.eduit.app.udp.client;

import java.io.IOException;
import java.net.*;

public class UDPClient {

    private DatagramSocket datagramSocket;

    public UDPClient(String clientHost , int clientPort) {
        try {
            datagramSocket = new DatagramSocket(clientPort, InetAddress.getByName(clientHost));
        } catch (SocketException e) {
          throw new RuntimeException(e.getMessage(),e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }


    public void readFromDatagramSocket(){

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
        while (true){

            try {
                datagramSocket.receive(packet);
                byte[] data = packet.getData();
                String message = new String(data).trim();
                System.out.println(" message received " + message);
                Thread.sleep(500l);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

        }

    }

}
