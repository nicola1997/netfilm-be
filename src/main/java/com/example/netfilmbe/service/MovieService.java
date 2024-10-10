package com.example.netfilmbe.service;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getAllMovies() {
        return movieRepository.getMovies();
    }


}
