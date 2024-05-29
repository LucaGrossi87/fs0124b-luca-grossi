package com.example.demo.handler;

import com.example.demo.DemoApplication;
import com.example.demo.model.Generale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GeneraleHandler implements UfficialeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private UfficialeHandler nextHandler;
    private Generale generale;

    public GeneraleHandler(Generale tenente) {
        this.generale = generale;
    }

    @Override
    public void setNextHandler(UfficialeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double stipendioMinimo) {
        if (generale.getStipendio() > stipendioMinimo) {
            logger.info("Generale: " + generale.getNome() + " con stipendio " + generale.getStipendio());
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(stipendioMinimo);
        }
    }
}
