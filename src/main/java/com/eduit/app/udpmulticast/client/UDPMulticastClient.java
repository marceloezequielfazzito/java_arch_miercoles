package com.eduit.app.udpmulticast.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class UDPMulticastClient {

    private MulticastSocket multicastSocket;
    private String clientName;

    public UDPMulticastClient(String multicastHost , int port,String clientName) {
        this.clientName = clientName;
        try {
            multicastSocket = new MulticastSocket(port);
            multicastSocket.joinGroup(InetAddress.getByName(multicastHost));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }


    public void receiveMulticastData(){
        byte[] buffer = new byte[100];
        while(true){

            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            try {
                multicastSocket.receive(packet);
                byte[] data = packet.getData();
                String message = new String(data).trim();
                System.out.println(" message received " + message + " client " + clientName);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }



}
