package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieCreatorKey {
    public Integer movieid;
    public Integer creatorId;

    @JsonCreator
    public MovieCreatorKey(
        @JsonProperty("movie_id") Integer movieid,
        @JsonProperty("creator_id")   Integer creatorId) {
        this.movieid = movieid;
        this.creatorId = creatorId;
    }


    public Integer getMovieid() {
        return movieid;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    @Override
    public String toString() {
        return "MovieCreatorKey{" +
                "movieid=" + movieid +
                ", creatorId=" + creatorId +
                '}';
    }
}
