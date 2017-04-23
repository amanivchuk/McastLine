package com.manivchuk;

import java.io.IOException;
import java.net.*;

/**
 * Created by Lenovo on 07.03.2017.
 */
public class MSender implements Runnable{
    private DatagramSocket socket;
    private DatagramPacket outPacket;
    private byte[] outBuf;
    private String multicastAddress;
    private int port;
    private String msg;

    public MSender(String multicastAddress, int port, String msg) {
        this.multicastAddress = multicastAddress;
        this.port = port;
        this.msg = msg;
    }

    public void run() {
        try {
            socket = new DatagramSocket();
            long counter = 0;

            while(true){
                String message = msg + counter;
                counter++;
                outBuf = message.getBytes();
                InetAddress inetAddress = InetAddress.getByName(multicastAddress);
                outPacket = new DatagramPacket(outBuf,outBuf.length,inetAddress,port);

                socket.send(outPacket);
                System.out.println("Server send msg: " + message);
                Thread.sleep(1000);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            socket.close();
        }
    }
}
