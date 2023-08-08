package com.kafkastreams.moviemodule;

import lombok.*;

import java.time.LocalDate;
import java.util.Set;
//import org.springframework.format.annotation.DateTimeFormat;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;


    private String name;


    private String type;


    private String synopsis;


    private String mpaRating;


    private LocalDate rYear;


    private Integer idmbRating;



    private Set<Actor> actors ;



    private Set<Creator> creators;



    private Set<Video> videos ;


    private String image ;

    public LocalDate getrYear() {
        return rYear;
    }

    private Set<Tag> tags;
    private Set<Category> categories;

}
