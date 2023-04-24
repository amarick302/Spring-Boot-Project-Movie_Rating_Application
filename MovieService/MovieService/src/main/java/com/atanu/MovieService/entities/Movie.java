package com.atanu.MovieService.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Movie {
    @Id
    private String movieId;

    @Column(name = "movie_name", nullable = false, unique = true)
    private String movieName;

    @Column(name = "Description", nullable = false, length = 1000)
    private String desc;

    @Column(name = "Actors", nullable = false)
    private String actors;
}
