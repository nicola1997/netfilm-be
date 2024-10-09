package com.example.netfilmbe.controller;
import com.example.netfilmbe.entity.Movie;
import com.example.netfilmbe.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // Ottieni tutti i film
    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Aggiungi un nuovo film
    @PostMapping("/createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // Modifica un film
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film non trovato con id: " + id));

        movie.setTitle(movieDetails.getTitle());
        movie.setDescrizione(movieDetails.getDescrizione());
        movie.setImg(movieDetails.getImg());
        movie.setAnno(movieDetails.getAnno());
        movie.setLikeCount(movieDetails.getLikeCount());
        movie.setCommenti(movieDetails.getCommenti());

        return movieRepository.save(movie);
    }

    // Elimina un film
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }

}

