package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor(force = true)
public class Movie {

    private final EventType _eventType;
    private final Integer id;

    private final Integer idmbRating;
    private final String image;
    private final String mpaRating;
    private final String name;


    private final Timestamp rYear;
    private final String synopsis;
    private final String type;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;
    private final Boolean notification;


    @JsonCreator
    public Movie(
            @JsonProperty("_eventType") EventType _eventType,
                @JsonProperty("id") Integer id,
                  @JsonProperty("idmb_rating") Integer idmbRating,
               @JsonProperty("image")  String image,
               @JsonProperty("mpa_rating") String mpaRating,
               @JsonProperty("name")  String name,
                @JsonProperty("r_year") Timestamp  rYear,
              @JsonProperty("synopsis")   String synopsis,
               @JsonProperty("type")  String type,
                @JsonProperty("created_on") Date createdOn,
                @JsonProperty("last_updated_on") Date lastUpdatedOn,
                  @JsonProperty("notification") Boolean notification
    ) {
        this._eventType = _eventType;
        this.id = id;
        this.idmbRating = idmbRating;
        this.image = image;
        this.mpaRating = mpaRating;
        this.name = name;
        this.rYear = rYear;
        this.synopsis = synopsis;
        this.type = type;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
        this.notification = notification;
    }

    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdmbRating() {
        return idmbRating;
    }

    public String getImage() {
        return image;
    }

    public String getMpaRating() {
        return mpaRating;
    }

    public String getName() {
        return name;
    }

    public Timestamp  getrYear() {
        return rYear;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getType() {
        return type;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public Boolean getNotification() {
        return notification;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "_eventType=" + _eventType +
                ", id=" + id +
                ", idmbRating=" + idmbRating +
                ", image='" + image + '\'' +
                ", mpaRating='" + mpaRating + '\'' +
                ", name='" + name + '\'' +
                ", rYear=" + rYear +
                ", synopsis='" + synopsis + '\'' +
                ", type='" + type + '\'' +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                ", notification=" + notification +
                '}';
    }
}

