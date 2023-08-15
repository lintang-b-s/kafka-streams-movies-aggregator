package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MovieActorKey {



    public Integer movieid;
    public Integer actorId;



    @JsonCreator
    public MovieActorKey(
         @JsonProperty("movie_id") Integer movieid,
        @JsonProperty("actor_id")    Integer actorId) {
        this.movieid = movieid;
        this.actorId = actorId;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public Integer getActorId() {
        return actorId;
    }



    @Override
    public String toString() {
        return "MovieActorKey{" +
                "movieid=" + movieid +
                ", actorId=" + actorId +
                '}';
    }
}
