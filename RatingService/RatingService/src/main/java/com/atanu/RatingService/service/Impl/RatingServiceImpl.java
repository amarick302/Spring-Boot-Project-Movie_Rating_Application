package com.atanu.RatingService.service.Impl;

import com.atanu.RatingService.DAO.RatingDAO;
import com.atanu.RatingService.entities.Rating;
import com.atanu.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    RatingDAO dao;

    @Override
    public Rating createRating(Rating rating) {
        return dao.save(rating);
    }

    @Override
    public Rating getRating(String user_name, String movie_name) {
        return dao.findRatingByUserNameAndAndMovieName(user_name,movie_name);
    }

    @Override
    public List<Rating> getRating(String username) {
        return dao.findRatingByUserName(username);
    }

    @Override
    public List<Rating> getAllRating() {
        return dao.findAll();
    }

    @Override
    public Rating updateRating(Rating rating) {
        Rating existedRating=dao.findRatingByUserNameAndAndMovieName(rating.getUserName(),rating.getMovieName());
        if(existedRating!=null){
            existedRating.setRating(rating.getRating());
            return dao.save(existedRating);
        }
        return null;
    }

    @Override
    public boolean deleteRating(String user_name, String movie_name) {
        Rating rating=dao.findRatingByUserNameAndAndMovieName(user_name,movie_name);
        if(rating!=null){
            dao.delete(rating);
            return true;
        }
        return false;
    }
}
