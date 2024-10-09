package com.example.netfilmbe.dto;

public class MovieDTO {

    private Long id;
    private String title;
    private String genre;

    public MovieDTO(Long id, String title, String genre) {
        this.id = id;
        this.title = title;
        this.genre = genre;
    }

    // getters e setters
}
