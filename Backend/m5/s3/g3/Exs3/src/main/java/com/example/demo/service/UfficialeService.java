package com.example.demo.service;

import com.example.demo.handler.UfficialeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UfficialeService {
    private final UfficialeHandler chainOfResponsibility;

    @Autowired
    public UfficialeService(UfficialeHandler chainOfResponsibility) {
        this.chainOfResponsibility = chainOfResponsibility;
    }

    public void processRequest(double stipendioMinimo) {
        chainOfResponsibility.handleRequest(stipendioMinimo);
    }
}
