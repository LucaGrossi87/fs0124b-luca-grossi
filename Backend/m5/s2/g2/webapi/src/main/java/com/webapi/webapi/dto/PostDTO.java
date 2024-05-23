package com.webapi.webapi.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    @Size(max = 30, message = "Max length 30 characters")
    @NotBlank(message = "Mandatory")
    private String category;

    @Size(max = 30, message = "Max length 30 characters")
    @NotBlank(message = "Mandatory")
    private String title;

    @Size(max = 30, message = "Max length 30 characters")
    @URL
    private String cover;

    @Size(max = 30, message = "Max length 30 characters")
    @NotBlank(message = "Mandatory")
    private String content;

    @NotNull
    @Max(value = 200)
    private int readingTime;

    @NotNull
    private Long authorId;

}
