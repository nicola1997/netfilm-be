package com.example.netfilmbe.controller;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.entity.Movie;
import com.example.netfilmbe.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    // Ottieni tutti i film (restituendo il DTO)
    @GetMapping("/getAllMovies")
    public List<MovieDTO> getAllMovies() {

        return movieService.getAllMovies();
    }

    // Aggiungi un nuovo film
    @PostMapping("/createMovie")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    // Modifica un film
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        return movieService.updateMovie(id, movieDetails);
    }

    // Elimina un film
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
