package com.manivchuk.beans;

/**
 * Created by Lenovo on 14.03.2017.
 */
public class LineConfig {
    private String hostname;
    private String ipSocket;
    private int portSocket;
    private String ipMcast;
    private int portMcast;

    public LineConfig() {
    }

    public LineConfig(String hostname, String ipSocket, int portSocket, String ipMcast, int portMcast) {
        this.hostname = hostname;
        this.ipSocket = ipSocket;
        this.portSocket = portSocket;
        this.ipMcast = ipMcast;
        this.portMcast = portMcast;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpSocket() {
        return ipSocket;
    }

    public void setIpSocket(String ipSocket) {
        this.ipSocket = ipSocket;
    }

    public int getPortSocket() {
        return portSocket;
    }

    public void setPortSocket(int portSocket) {
        this.portSocket = portSocket;
    }

    public String getIpMcast() {
        return ipMcast;
    }

    public void setIpMcast(String ipMcast) {
        this.ipMcast = ipMcast;
    }

    public int getPortMcast() {
        return portMcast;
    }

    public void setPortMcast(int portMcast) {
        this.portMcast = portMcast;
    }
}
