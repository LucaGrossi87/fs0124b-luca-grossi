package com.example.demo.handler;

import com.example.demo.DemoApplication;
import com.example.demo.model.Capitano;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CapitanoHandler implements UfficialeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private UfficialeHandler nextHandler;
    private Capitano capitano;

    public CapitanoHandler(Capitano tenente) {
        this.capitano = capitano;
    }

    @Override
    public void setNextHandler(UfficialeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double stipendioMinimo) {
        if (capitano.getStipendio() > stipendioMinimo) {
            logger.info("Capitano: " + capitano.getNome() + " con stipendio " + capitano.getStipendio());
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(stipendioMinimo);
        }
    }
}
