package com.example.demo.config;

import com.example.demo.adapter.DataAdapter;
import com.example.demo.model.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataConfig {

    @Bean
    public DataAdapter dataAdapter(Info info){
        return new DataAdapter(info);
    }

    @Bean
    public Info info (){
        return new Info("nome","cognome",new Date());
    }
}
