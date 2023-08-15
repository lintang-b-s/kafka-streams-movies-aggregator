package com.kafkastreams.movie.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.debezium.time.ZonedTimestamp;

import java.util.Date;


public class Creator {
    private final EventType _eventType;
    private final Integer id;
    private final String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date createdOn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private final Date lastUpdatedOn;


    @JsonCreator
    public Creator(
            @JsonProperty("_eventType") EventType _eventType,
            @JsonProperty("id") Integer id,
            @JsonProperty("name")  String name,
            @JsonProperty("created_on") Date createdOn,
            @JsonProperty("last_updated_on") Date lastUpdatedOn
    ) {
        this._eventType = _eventType;
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.lastUpdatedOn = lastUpdatedOn;
    }


    public EventType get_eventType() {
        return _eventType;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    @Override
    public String toString() {
        return "Creator{" +
                "_eventType=" + _eventType +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", createdOn=" + createdOn +
                ", lastUpdatedOn=" + lastUpdatedOn +
                '}';
    }
}
