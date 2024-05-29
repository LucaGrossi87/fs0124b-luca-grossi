package com.example.demo.controller;

import com.example.demo.service.UfficialeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UfficialeController {
    private final UfficialeService ufficialeService;

    @Autowired
    public UfficialeController(UfficialeService ufficialeService) {
        this.ufficialeService = ufficialeService;
    }

    @GetMapping("/ufficiali")
    public void handleRequest(@RequestParam double stipendioMinimo) {
        ufficialeService.processRequest(stipendioMinimo);
    }
}
