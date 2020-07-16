package com.eduit.app.udp.server;

import java.io.IOException;
import java.net.*;

public class UDPServer {

    private DatagramSocket datagramSocket;

    public UDPServer(String host , int port) {
        try {
            datagramSocket = new DatagramSocket(port, InetAddress.getByName(host));
        } catch (SocketException e) {
           throw new RuntimeException(e.getMessage(),e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e.getMessage(),e);
        }
    }


    public void sendDataTo(String receiverHost , int receiverPort){
        int packetNumber = 0;
        while (true){
            String message = " message number " + packetNumber;
            System.out.println(" log : sending message " + message + " to " + receiverHost + ":" + receiverPort );
            byte[] data = message.getBytes();
            try {
                DatagramPacket packet = new DatagramPacket(data,data.length,InetAddress.getByName(receiverHost),receiverPort);
                datagramSocket.send(packet);
                packetNumber++;

                Thread.sleep(500L);


            } catch (UnknownHostException e) {
                System.err.println(" could not send data to " + receiverHost + ":" + receiverPort);
            } catch (IOException e) {
                System.err.println(" could not send data to " + receiverHost + ":" + receiverPort);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage(),e);
            }
        }
    }


}
