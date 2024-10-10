package com.example.netfilmbe.controller;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.dto.UserDTO;
import com.example.netfilmbe.entity.Movie;
import com.example.netfilmbe.service.MovieService;
import com.example.netfilmbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody UserDTO user) {
        userService.saveUser(user);
    }

    @GetMapping("/getAllMovies")
    public List<MovieDTO> getAllMovies() {

        return movieService.getAllMovies();
    }


}
