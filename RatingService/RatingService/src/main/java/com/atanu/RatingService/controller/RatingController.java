package com.atanu.RatingService.controller;

import com.atanu.RatingService.entities.Rating;
import com.atanu.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> saveRating(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping(value = "/{user_name}/{movie_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> findRating(@PathVariable String user_name, @PathVariable String movie_name){
        WebClient webClient = WebClient.create("http://localhost:8081");
        Rating rating = ratingService.getRating(user_name,movie_name);
        Mono<Object> movieInfo = webClient.get().uri("/movie/"+movie_name).retrieve().bodyToMono(Object.class);
        rating.setMovieInfo(movieInfo.block());
        return ResponseEntity.ok(rating);
    }

    @GetMapping(value = "/{user_name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> findRating(@PathVariable String user_name){
        WebClient webClient = WebClient.create("http://localhost:8081");
        List<Rating> ratingList = ratingService.getRating(user_name);
        List<Rating> list=new ArrayList<>();
        ratingList.forEach((rating)->{
            Mono<Object> movieInfo = webClient.get().uri("/movie/"+rating.getMovieName()).retrieve().bodyToMono(Object.class);
            rating.setMovieInfo(movieInfo.block());
            list.add(rating);
        });
        return ResponseEntity.ok(list);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rating>> findAllRating(){
        return ResponseEntity.ok(ratingService.getAllRating());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating){
        return ResponseEntity.ok(ratingService.updateRating(rating));
    }

    @DeleteMapping(value = "/{user_name}/{movie_name}")
    public ResponseEntity<Boolean> deleteRating(@PathVariable String user_name,@PathVariable String movie_name){
        return ResponseEntity.ok(ratingService.deleteRating(user_name,movie_name));
    }
}
