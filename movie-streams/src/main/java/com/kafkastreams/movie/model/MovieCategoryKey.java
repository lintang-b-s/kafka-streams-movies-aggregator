package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCategoryKey {

    public Integer movieid;
    public Integer categoryId;

    @JsonCreator
    public MovieCategoryKey(
            @JsonProperty("movie_id") Integer movieid,
            @JsonProperty("category_id")   Integer categoryId
    ) {
        this.movieid = movieid;
        this.categoryId = categoryId;
    }


    public Integer getMovieid() {
        return movieid;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "MovieCategoryKey{" +
                "movieid=" + movieid +
                ", categoryId=" + categoryId +
                '}';
    }
}
