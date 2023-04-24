package com.atanu.RatingService.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Persistent;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ratingId;

    @Column(name = "Rating")
    private float rating;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Transient
    private Object movieInfo;
}
