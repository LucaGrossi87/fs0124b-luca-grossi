package com.example.demo.handler;

import com.example.demo.DemoApplication;
import com.example.demo.model.Maggiore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaggioreHandler implements UfficialeHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

    private UfficialeHandler nextHandler;
    private Maggiore maggiore;

    public MaggioreHandler(Maggiore tenente) {
        this.maggiore = maggiore;
    }

    @Override
    public void setNextHandler(UfficialeHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(double stipendioMinimo) {
        if (maggiore.getStipendio() > stipendioMinimo) {
            logger.info("Maggiore: " + maggiore.getNome() + " con stipendio " + maggiore.getStipendio());
        }
        if (nextHandler != null) {
            nextHandler.handleRequest(stipendioMinimo);
        }
    }
}
