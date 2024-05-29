package com.example.demo.handler;

import com.example.demo.DemoApplication;
import com.example.demo.model.Colonnello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColonnelloHandler implements UfficialeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private UfficialeHandler nextHandler;
    private Colonnello colonnello;

    public ColonnelloHandler(Colonnello tenente) {
        this.colonnello = colonnello;
    }

    @Override
    public void setNextHandler(UfficialeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double stipendioMinimo) {
        if (colonnello.getStipendio() > stipendioMinimo) {
            logger.info("Colonnello: " + colonnello.getNome() + " con stipendio " + colonnello.getStipendio());
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(stipendioMinimo);
        }
    }
}
