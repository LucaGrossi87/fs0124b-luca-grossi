package com.example.demo.service;

import com.example.demo.adapter.DataAdapter;
import com.example.demo.interf.DataSource;
import com.example.demo.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DataSvc {
    private final DataSource ds;

    @Autowired
    public DataSvc(DataSource ds){
        this.ds=ds;
    }

    public UserData ObtainData(){
        UserData userData=new UserData(ds.getNomeCompleto(),ds.getEta());
        return userData;
    }
}
