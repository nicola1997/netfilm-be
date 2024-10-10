package com.example.netfilmbe.service;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.entity.Movie;
import com.example.netfilmbe.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {this.movieRepository = movieRepository;}

    // Trasforma una lista di Movie in MovieDTO
    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> new MovieDTO(
                        movie.getId(),
                        movie.getAnno(),
                        movie.getDescrizione(),
                        movie.getGenre(),
                        movie.getImg(),
                        movie.getLikeCount(),
                        movie.getTitle()
                       ))
                .collect(Collectors.toList());
    }

    // Crea un nuovo film
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Modifica un film esistente
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film non trovato con id: " + id));

        movie.setTitle(movieDetails.getTitle());
        movie.setDescrizione(movieDetails.getDescrizione());
        movie.setImg(movieDetails.getImg());
        movie.setAnno(movieDetails.getAnno());
        movie.setLikeCount(movieDetails.getLikeCount());
        movie.setGenre(movieDetails.getGenre());

        return movieRepository.save(movie);
    }

    // Elimina un film
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
