package com.example.demo.adapter;

import com.example.demo.interf.DataSource;
import com.example.demo.model.Info;

import java.time.LocalDate;

public class DataAdapter implements DataSource {
    private final Info info;

    public DataAdapter(Info info) {
        this.info = info;
    }

    @Override
    public String getNomeCompleto() {
        return info.getNome()+info.getCognome();
    }

    @Override
    public int getEta() {
        return LocalDate.now().getYear()-info.getDataDiNascita().getYear();
    }
}
