package com.atanu.MovieService.service.impl;

import com.atanu.MovieService.DAO.MovieDAO;
import com.atanu.MovieService.entities.Movie;
import com.atanu.MovieService.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDAO dao;

    @Override
    public Movie createMovie(Movie movie) {
        return dao.save(movie);
    }

    @Override
    public Movie getMovie(String movie_name) {
        Movie movie=dao.findByMovieName(movie_name);
        if(movie!=null){
            return dao.findByMovieName(movie_name);
        }
        return null;
    }

    @Override
    public List<Movie> getAllMovies() {
        return dao.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existedMovie=dao.findByMovieName(movie.getMovieName());
        if(existedMovie!=null){
            existedMovie.setActors(movie.getActors());
            existedMovie.setDesc(movie.getDesc());
            return dao.save(existedMovie);
        }
        return null;
    }

    @Override
    public boolean deleteMovie(String movie_name) {
        Movie existedMovie=dao.findByMovieName(movie_name);
        if(existedMovie!=null){
            dao.delete(existedMovie);
            return true;
        }
        return false;
    }
}
