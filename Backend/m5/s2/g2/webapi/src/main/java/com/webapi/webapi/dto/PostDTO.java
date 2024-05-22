package com.webapi.webapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
    private Long authorId;

}
