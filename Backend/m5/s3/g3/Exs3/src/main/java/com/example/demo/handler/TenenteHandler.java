package com.example.demo.handler;

import com.example.demo.DemoApplication;
import com.example.demo.model.Tenente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenenteHandler implements UfficialeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private UfficialeHandler nextHandler;
    private Tenente tenente;

    public TenenteHandler(Tenente tenente) {
        this.tenente = tenente;
    }

    @Override
    public void setNextHandler(UfficialeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double stipendioMinimo) {
        if (tenente.getStipendio() > stipendioMinimo) {
            logger.info("Tenente: " + tenente.getNome() + " con stipendio " + tenente.getStipendio());
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(stipendioMinimo);
        }
    }
}
