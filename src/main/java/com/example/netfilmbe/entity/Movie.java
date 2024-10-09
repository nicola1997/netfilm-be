package com.example.netfilmbe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String descrizione;

    private String img;

    private int anno;

    private int likeCount;

    private String genre;  // Aggiunto campo genre per il genere del film

    @ElementCollection
    @CollectionTable(name = "movie_comments", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "comment")
    private List<String> commenti;
}
