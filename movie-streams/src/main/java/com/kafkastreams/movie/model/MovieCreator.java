package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.debezium.time.ZonedTimestamp;

import java.util.Date;


public class MovieCreator {
    private final EventType _eventType;
    private final Integer movieId;

    private final Integer creatorId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;

    @JsonCreator
    public MovieCreator( @JsonProperty("_eventType")  EventType _eventType,
                         @JsonProperty("movie_id")       Integer movieId,
                       @JsonProperty("creator_id") Integer creatorId,
                         @JsonProperty("created_on") Date createdOn,
                         @JsonProperty("last_updated_on") Date lastUpdatedOn) {
        this._eventType = _eventType;
        this.movieId = movieId;
        this.creatorId = creatorId;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    @Override
    public String toString() {
        return "MovieCreator{" +
                "_eventType=" + _eventType +
                ", movieId=" + movieId +
                ", creatorId=" + creatorId +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                '}';
    }
}
