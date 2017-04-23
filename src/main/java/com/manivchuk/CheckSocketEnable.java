package com.manivchuk;

import com.manivchuk.beans.LineConfig;
import com.manivchuk.beans.StatusConnect;
import com.manivchuk.statusLine.LineQueueStatus;

import java.io.IOException;
import java.net.*;
import java.util.Date;

/**
 * Created by Lenovo on 11.03.2017.
 */
public class CheckSocketEnable implements Runnable{
    private LineConfig lineConfig;
    private boolean socketIsAlive = false;

    private InetAddress inetAddress;
    private MulticastSocket socket;
    private DatagramPacket inPacket;
    private byte[] inBuf;
    private StatusConnect statusConnect;

    public CheckSocketEnable(LineConfig lineConfig) {
        this.lineConfig = lineConfig;
        inBuf = new byte[2048];
        statusConnect = new StatusConnect();
    }

    public void run() {
        while(true){
            socketIsAlive = isSocketAlive(lineConfig.getHostname(),lineConfig.getIpSocket(), lineConfig.getPortSocket());
            statusConnect.setHostname(lineConfig.getHostname());
            if(socketIsAlive){
                statusConnect.setStatus(true);
                LineQueueStatus.addLine(statusConnect);
                try {
                    socket = new MulticastSocket(lineConfig.getPortMcast());
                    inetAddress = InetAddress.getByName(lineConfig.getIpMcast());
                    socket.joinGroup(inetAddress);
                    showMulticastData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                statusConnect.setStatus(false);
                LineQueueStatus.addLine(statusConnect);
                System.out.println("Remote host is unreachable!!!" + new Date());
            }
            someSleep(2000);
        }
    }

    private boolean isSocketAlive(String hostname, String ipSocket, int port){
        boolean isAlive = false;
        SocketAddress socketAddress = new InetSocketAddress(ipSocket,port);
        Socket socket = new Socket();
        int time = 2000;
        try {
            socket.connect(socketAddress,time);
            socket.close();
            isAlive = true;
            System.out.println("Connect to " + hostname + " successful!");
        } catch (SocketTimeoutException e) {
            return isAlive;
        } catch (SocketException e){
            return isAlive;
        } catch (IOException e){
            e.printStackTrace();
        }
        return isAlive;
    }

    private void showMulticastData() {
        inPacket = new DatagramPacket(inBuf,inBuf.length);
             try{
                socket.receive(inPacket);
                String msg = new String(inBuf,0,inPacket.getLength());
                System.out.println("From " + inPacket.getAddress() + ":" + inPacket.getPort() + " msg " + msg + " : " + new Date());
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void someSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
