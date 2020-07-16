package com.eduit.app.udpmulticast.server;

import java.io.IOException;
import java.net.*;

public class UDPMulticastServer {

    private DatagramSocket datagramSocket;

    public UDPMulticastServer() {
        try {
            datagramSocket = new DatagramSocket();
        } catch (SocketException e) {
           throw new RuntimeException(e.getMessage(),e);
        }
    }


    public void sendMulticastData(){
        int packetCounter = 0;
        while(true){
            String message = " multicast message number " + packetCounter;
            byte[] data = message.getBytes();
            try {
                DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getByName("235.1.1.1"),4000);
                System.out.println(" sending multicast message " + message + " to 235.1.1.1:4000");
                datagramSocket.send(packet);
                Thread.sleep(500l);
                packetCounter++;
            } catch (UnknownHostException e) {
                System.err.println(e.getMessage());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }


        }

    }



}
