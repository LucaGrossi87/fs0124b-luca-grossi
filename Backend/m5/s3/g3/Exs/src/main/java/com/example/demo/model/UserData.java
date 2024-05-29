package com.example.demo.model;

import com.example.demo.interf.DataSource;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserData {
    private String nomeCompleto;
    private int eta;

    public void getData(DataSource ds){
        nomeCompleto=ds.getNomeCompleto();
        eta=ds.getEta();
    }
}
