package com.kafkastreams.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder
@Entity
@Table(name = "actors")
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Actor name is required")
    private String name;


    @CreationTimestamp(source = SourceType.DB)
    private Instant createdOn;
    @UpdateTimestamp(source = SourceType.DB)
    private Instant lastUpdatedOn;


    public ActorEntity( String name) {

        this.name = name;
    }

//    @JsonIgnore
    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    private Set<MovieEntity> movies = new HashSet<>();



    public int getId() {
        return id;
    }

    public ActorEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ActorEntity setName(String name) {
        this.name = name;
        return this;
    }

    public Set<MovieEntity> getMovies() {
        return movies;
    }

    public ActorEntity setMovies(Set<MovieEntity> movies) {
        this.movies = movies;
        return this;
    }

//    public void addMovie(MovieEntity movie) {
//        this.movies.add(movie);
//    }
//
    public void removeMovie(MovieEntity movie) {
        this.movies.remove(movie);
    }



}
