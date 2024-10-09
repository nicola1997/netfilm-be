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

    @Column(name = "title") // corrisponde alla colonna "TITLE"
    private String title;

    @Column(name = "descrizione", length = 1000) // corrisponde alla colonna "DESCRIZIONE"
    private String descrizione;

    @Column(name = "img") // corrisponde alla colonna "IMG"
    private String img;

    @Column(name = "anno") // corrisponde alla colonna "ANNO"
    private int anno;

    @Column(name = "like_count") // corrisponde alla colonna "LIKE_COUNT"
    private int likeCount;

    @Column(name = "genre") // corrisponde alla colonna "GENRE"
    private String genre;

    @ElementCollection
    @CollectionTable(name = "movie_comments", joinColumns = @JoinColumn(name = "movie_id"))
    @Column(name = "comment")
    private List<String> commenti;
}

