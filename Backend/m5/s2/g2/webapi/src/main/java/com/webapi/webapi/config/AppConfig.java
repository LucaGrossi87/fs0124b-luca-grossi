package com.webapi.webapi.config;

import com.webapi.webapi.model.Author;
import com.webapi.webapi.model.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig {

    @Bean
    public Author author1() {
        return new Author("John", "Doe", "john.doe@example.com", LocalDate.of(1980, 1, 1), "https://ui-avatars.com/api/?name=John+Doe");
    }

    @Bean
    public Author author2() {
        return new Author("Jane", "Smith", "jane.smith@example.com", LocalDate.of(1990, 2, 2), "https://ui-avatars.com/api/?name=Jane+Smith");
    }

    @Bean
    public Author author3() {
        return new Author("Michael", "Brown", "michael.brown@example.com", LocalDate.of(1975, 3, 3), "https://ui-avatars.com/api/?name=Michael+Brown");
    }

    @Bean
    public Author author4() {
        return new Author("Emily", "Davis", "emily.davis@example.com", LocalDate.of(1985, 4, 4), "https://ui-avatars.com/api/?name=Emily+Davis");
    }

    @Bean
    public Author author5() {
        return new Author("David", "Wilson", "david.wilson@example.com", LocalDate.of(1995, 5, 5), "https://ui-avatars.com/api/?name=David+Wilson");
    }

    @Bean
    public Post post1() {
        return new Post("Category1", "Title1", "https://picsum.photos/200", "Content1", 5, author1());
    }

    @Bean
    public Post post2() {
        return new Post("Category2", "Title2", "https://picsum.photos/200", "Content2", 10, author2());
    }

    @Bean
    public Post post3() {
        return new Post("Category3", "Title3", "https://picsum.photos/200", "Content3", 15, author3());
    }

    @Bean
    public Post post4() {
        return new Post("Category4", "Title4", "https://picsum.photos/200", "Content4", 20, author4());
    }

    @Bean
    public Post post5() {
        return new Post("Category5", "Title5", "https://picsum.photos/200", "Content5", 25, author5());
    }
}
