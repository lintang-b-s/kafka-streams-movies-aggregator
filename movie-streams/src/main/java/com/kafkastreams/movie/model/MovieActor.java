package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.debezium.time.ZonedTimestamp;

import java.util.Date;


public class MovieActor {
    private final EventType _eventType;
    private final Integer movieId;
    private final Integer actorId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;

    @JsonCreator
    public MovieActor(
            @JsonProperty("_eventType")  EventType _eventType,
            @JsonProperty("movie_id")       Integer movieId,
            @JsonProperty("actor_id")          Integer actorId,
            @JsonProperty("created_on") Date createdOn,
            @JsonProperty("last_updated_on") Date lastUpdatedOn
    ) {
        this._eventType = _eventType;
        this.movieId = movieId;
        this.actorId = actorId;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
    }


    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getActorId() {
        return actorId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    @Override
    public String toString() {
        return "MovieActor{" +
                "_eventType=" + _eventType +
                ", movieId=" + movieId +
                ", actorId=" + actorId +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                '}';
    }
}
