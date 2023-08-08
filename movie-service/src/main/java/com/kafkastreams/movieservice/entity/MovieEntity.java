package com.kafkastreams.movieservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String type;

    private String synopsis;

    private String mpaRating;

    private Timestamp rYear;

    private int idmbRating;
    private String image;


    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name="movie_actor",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private Set<ActorEntity> actors= new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="movie_creator",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "creator_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private Set<CreatorEntity> creators= new HashSet<>() ;


    @OneToMany(mappedBy = "movie",  fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<VideoEntity> videos = new HashSet<>();


    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(
        name = "movie_tag",
        joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private Set<TagEntity> tags = new HashSet<>();




    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(
            name = "movie_category",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Set<CategoryEntity> categories = new HashSet<>();



    public int getId() {
        return id;
    }

    public MovieEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MovieEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public MovieEntity setType(String type) {
        this.type = type;
        return this;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public MovieEntity setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public String getMpaRating() {
        return mpaRating;
    }

    public MovieEntity setMpaRating(String mpaRating) {
        this.mpaRating = mpaRating;
        return this;
    }

    public Timestamp getrYear() {
        return rYear;
    }

    public MovieEntity setrYear(Timestamp rYear) {
        this.rYear = rYear;
        return this;
    }

    public int getIdmbRating() {
        return idmbRating;
    }

    public MovieEntity setIdmbRating(int idmbRating) {
        this.idmbRating = idmbRating;
        return this;
    }



    public MovieEntity addActor(ActorEntity actor) {
        this.actors.add(actor);
        actor.getMovies().add(this);
        return this;
    }

    public MovieEntity addCreator(CreatorEntity creator) {
        this.creators.add(creator);
        creator.getMovies().add(this);
        return this;
    }

    public Set<ActorEntity> getActors() {
        return actors;
    }

    public MovieEntity setActors(Set<ActorEntity> actors) {
        this.actors = actors;
        return this;
    }

    public Set<CreatorEntity> getCreators() {
        return creators;
    }

    public MovieEntity setCreators(Set<CreatorEntity> creators) {
        this.creators = creators;
        return this;
    }


    public Set<VideoEntity> getVideos() {
        return videos;
    }

    public MovieEntity setVideos(Set<VideoEntity> videos) {
        this.videos = videos;
        return this;
    }

    public String getImage() {
        return image;
    }

    public MovieEntity setImage(String image) {
        this.image = image;
        return this;
    }

    public void removeVideos() {
        this.videos.clear();
    }

    public void deleteVideo(VideoEntity v){
        this.videos.remove(v);
    }

    public void addMovie(VideoEntity v) {
        this.videos.add(v);
    }

    public Set<TagEntity> getTags() {
        return tags;
    }

    public MovieEntity setTags(Set<TagEntity> tags) {
        this.tags = tags;
        return this;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public MovieEntity setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
        return this;
    }




    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", mpaRating='" + mpaRating + '\'' +
                ", rYear=" + rYear +
                ", idmbRating=" + idmbRating +
                ", image='" + image + '\'' +
                ", actors=" + actors +
                ", creators=" + creators +
                ", videos=" + videos +
                ", tags=" + tags +
                ", categories=" + categories +
                '}';
    }
}
