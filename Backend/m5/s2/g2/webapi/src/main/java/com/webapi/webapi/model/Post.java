package com.webapi.webapi.model;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
public class Post {

//    @Id
//    @GeneratedValue
    private Long id;

    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;

    public Post (Long id, String category, String title, String cover, String content, int readingTime){
        this.id=id;
        this.category=category;
        this.title=title;
        this.cover=cover;
        this.content=content;
        this.readingTime=readingTime;
    }
}
