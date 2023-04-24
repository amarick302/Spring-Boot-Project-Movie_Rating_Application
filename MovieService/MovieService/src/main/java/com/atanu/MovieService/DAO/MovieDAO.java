package com.atanu.MovieService.DAO;

import com.atanu.MovieService.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDAO extends JpaRepository<Movie,String> {
    public Movie findByMovieName(String movie_name);
}
