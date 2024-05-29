package com.example.demo.handler;

public interface UfficialeHandler {
    void setNextHandler(UfficialeHandler nextHandler);
    void handleRequest(double stipendioMinimo);
}
