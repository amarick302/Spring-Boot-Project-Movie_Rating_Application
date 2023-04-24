package com.atanu.MovieService.service;

import com.atanu.MovieService.entities.Movie;

import java.util.List;

public interface MovieService {
    public Movie createMovie(Movie movie);
    public Movie getMovie(String movie_name);
    public List<Movie> getAllMovies();
    public Movie updateMovie(Movie movie);
    public boolean deleteMovie(String movie_name);
}
