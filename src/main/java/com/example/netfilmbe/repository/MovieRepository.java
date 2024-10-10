package com.example.netfilmbe.repository;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    //new MovieDTO(
    //                        movie.getId(),
    //                        movie.getAnno(),
    //                        movie.getDescrizione(),
    //                        movie.getGenre(),
    //                        movie.getImg(),
    //                        movie.getLikeCount(),
    //                        movie.getTitle()
    //                       )
    @Query("select new com.example.netfilmbe.dto.MovieDTO(m.id,m.anno,m.descrizione,m.genre,m.img,m.likeCount,m.title) FROM Movie as m ")
    public List<MovieDTO> getMovies();
}

