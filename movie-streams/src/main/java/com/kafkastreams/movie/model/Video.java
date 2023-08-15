package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.debezium.time.ZonedTimestamp;

import java.util.Date;


public class Video {
    private final EventType _eventType;
    private final Integer id;
    private final Integer length;
    private final String publicId;
    private final String synopsis;
    private final String title;
    private final String url;
    private final Integer movieId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;

    @JsonCreator
    public Video(@JsonProperty("_eventType") EventType _eventType,
                 @JsonProperty("id") Integer id,
                 @JsonProperty("length")  Integer length,
                 @JsonProperty("public_id")  String publicId,
                 @JsonProperty("synopsis") String synopsis,
                 @JsonProperty("title")  String title,
                 @JsonProperty("url")  String url,
                 @JsonProperty("movie_id") Integer movieId,
                 @JsonProperty("created_on") Date createdOn,
                 @JsonProperty("last_updated_on") Date lastUpdatedOn) {
        this._eventType = _eventType;
        this.id = id;
        this.length = length;
        this.publicId = publicId;
        this.synopsis = synopsis;
        this.title = title;
        this.url = url;
        this.movieId = movieId;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
    }


    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLength() {
        return length;
    }

    public String getPublicId() {
        return publicId;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    @Override
    public String toString() {
        return "Video{" +
                "_eventType=" + _eventType +
                ", id=" + id +
                ", length=" + length +
                ", publicId='" + publicId + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", movieId=" + movieId +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                '}';
    }
}
