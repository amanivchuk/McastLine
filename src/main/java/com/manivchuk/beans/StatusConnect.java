package com.manivchuk.beans;

/**
 * Created by Lenovo on 11.03.2017.
 */
public class StatusConnect {
    private String hostname;
    private boolean status;

    public StatusConnect() {
    }

    public StatusConnect(String hostname, boolean status) {
        this.hostname = hostname;
        this.status = status;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
