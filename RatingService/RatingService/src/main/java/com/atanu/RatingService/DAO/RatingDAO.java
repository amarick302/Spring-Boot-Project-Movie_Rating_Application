package com.atanu.RatingService.DAO;

import com.atanu.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingDAO extends JpaRepository<Rating,Integer> {

    public Rating findRatingByUserNameAndAndMovieName(String user_name,String movie_name);
    public List<Rating> findRatingByUserName(String username);
}
