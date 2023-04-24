package com.atanu.RatingService.service;

import com.atanu.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {

    public Rating createRating(Rating rating);
    public Rating getRating(String user_name, String movie_name);
    public List<Rating> getRating(String username);
    public List<Rating> getAllRating();
    public Rating updateRating(Rating rating);
    public boolean deleteRating(String user_name, String movie_name);
}
