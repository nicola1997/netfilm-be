package com.example.netfilmbe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private int anno;
    private String descrizione;
    private String genre;
    private String img;
    private int likeCount;
    private String title;
}
