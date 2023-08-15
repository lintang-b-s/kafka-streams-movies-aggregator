package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.debezium.time.ZonedTimestamp;

import java.util.Date;

public class MovieCategory {

    private final EventType _eventType;
    private final Integer movieId;
    private final Integer categoryId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;

    @JsonCreator
    public MovieCategory(
            @JsonProperty("_eventType")  EventType _eventType,
            @JsonProperty("movie_id")       Integer movieId,
            @JsonProperty("category_id")           Integer categoryId,
            @JsonProperty("created_on") Date createdOn,
            @JsonProperty("last_updated_on") Date lastUpdatedOn
    ) {
        this._eventType = _eventType;
        this.movieId = movieId;
        this.categoryId = categoryId;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    @Override
    public String toString() {
        return "MovieCategory{" +
                "_eventType=" + _eventType +
                ", movieId=" + movieId +
                ", categoryId=" + categoryId +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                '}';
    }
}
