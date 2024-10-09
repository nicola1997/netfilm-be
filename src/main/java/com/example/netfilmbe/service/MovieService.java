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

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .map(movie -> new MovieDTO(movie.getId(), movie.getTitle(), movie.getGenre()))
                .collect(Collectors.toList());

    }
}
