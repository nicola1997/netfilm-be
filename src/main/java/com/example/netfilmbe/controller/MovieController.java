package com.example.netfilmbe.controller;

import com.example.netfilmbe.dto.MovieDTO;
import com.example.netfilmbe.dto.UserDTO;
import com.example.netfilmbe.service.MovieService;
import com.example.netfilmbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO user) {
        boolean userExists = userService.isUser(user);
        if (userExists) {
            return ResponseEntity.ok("Login riuscito");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali non valide");
        }
    }
}
