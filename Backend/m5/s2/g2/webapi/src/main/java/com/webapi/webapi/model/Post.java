package com.webapi.webapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Entity
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Post (String category, String title, String cover, String content, int readingTime, Author author){
        this.category=category;
        this.title=title;
        this.cover=cover;
        this.content=content;
        this.readingTime=readingTime;
        this.author=author;
    }
}
