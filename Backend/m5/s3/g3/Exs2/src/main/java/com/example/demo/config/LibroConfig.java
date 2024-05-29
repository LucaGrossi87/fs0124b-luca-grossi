package com.example.demo.config;

import com.example.demo.composite.Libro;
import com.example.demo.composite.Sezione;
import com.example.demo.leaf.Pagina;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LibroConfig {

    @Bean
    public Pagina pagina1(){
        return new Pagina("Lorem", 7);
    };
    @Bean
    public Pagina pagina2(){
        return new Pagina("Ipsum", 8);
    };

    List<String> authors = new ArrayList<>();
    List<Sezione> sections = new ArrayList<>();
    List<Pagina> pages=new ArrayList<>();

    @Bean
    public Libro libro (){
        authors.add("Lorem");
        authors.add("Ipsum");
        pages.add(pagina1());
        pages.add(pagina2());
        sections.add(new Sezione("sezione1", pages, pages.size()));
        return new Libro("Lorem", authors, sections, 19.90, pages.size());
    }
}
