package com.saeid.apigetway.model;

public class ServiceRequest {
    private String server;
    private int port;
    private String path;

    public ServiceRequest(String server, int port, String path) {
        this.server = server;
        this.port = port;
        this.path = path;
    }

    public ServiceRequest() {
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return getServer() + ":" + getPort() + getPath();
    }
}
