package com.atanu.MovieService.controller;

import com.atanu.MovieService.entities.Movie;
import com.atanu.MovieService.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        movie.setMovieId(UUID.randomUUID().toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movie));
    }

    @GetMapping(value = "/{movie_name}")
    public ResponseEntity getMovie(@PathVariable String movie_name){
        Movie movie=movieService.getMovie(movie_name);
        if(movie!=null){
            return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovie(movie_name));
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("No such Movie Present with that movie name");
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping(value = "/{movie_name}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable String movie_name){
        return ResponseEntity.ok(movieService.deleteMovie(movie_name));
    }

}
