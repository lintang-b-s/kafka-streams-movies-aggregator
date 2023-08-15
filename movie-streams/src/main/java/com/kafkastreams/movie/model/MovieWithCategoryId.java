//package com.kafkastreams.movie.model;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Builder;
//import lombok.Setter;
//
//import java.util.Date;
//import java.util.List;
//
//
//@Builder
//@Setter
//public class MovieWithCategoryId {
//    private final Integer categoryId;
//    private final String title;
//    private final Integer movieId;
//    private final List<String> genre;
//    private final String synopsis;
//
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
//    private final Date releaseYear;
//    private final String image;
//    private final  Float rating;
//    private final List<String> director;
//    private final List<String> cast;
//    private final List<String> url;
//
//
//
//    @JsonCreator
//    public MovieWithCategoryId(
//         @JsonProperty("category_id")  Integer categoryId,
//         @JsonProperty("title")   String title,
//            @JsonProperty("movie_id")     Integer movieId,
//            @JsonProperty("genre")   List<String> genre,
//            @JsonProperty("synopsis")  String synopsis,
//            @JsonProperty("release_year")    Date releaseYear,
//            @JsonProperty("image")   String image,
//            @JsonProperty("rating")   Float rating,
//            @JsonProperty("director")   List<String> director,
//            @JsonProperty("cast")    List<String> cast,
//            @JsonProperty("url")   List<String> url
//    )
//    {
//        this.categoryId = categoryId;
//        this.title = title;
//        this.movieId = movieId;
//
//        this.genre = genre;
//        this.synopsis = synopsis;
//        this.releaseYear = releaseYear;
//        this.image = image;
//        this.rating = rating;
//        this.director = director;
//        this.cast = cast;
//        this.url = url;
//    }
//
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public List<String> getGenre() {
//        return genre;
//    }
//
//    public String getSynopsis() {
//        return synopsis;
//    }
//
//    public Date getReleaseYear() {
//        return releaseYear;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public Float getRating() {
//        return rating;
//    }
//
//    public List<String> getDirector() {
//        return director;
//    }
//
//    public List<String> getCast() {
//        return cast;
//    }
//
//    public List<String> getUrl() {
//        return url;
//    }
//
//    public Integer getMovieId() {
//        return movieId;
//    }
//
//    @Override
//    public String toString() {
//        return "MovieWithCategoryId{" +
//                "categoryId=" + categoryId +
//                ", title='" + title + '\'' +
//                ", genre=" + genre +
//                ", synopsis='" + synopsis + '\'' +
//                ", releaseYear=" + releaseYear +
//                ", image='" + image + '\'' +
//                ", rating=" + rating +
//                ", director=" + director +
//                ", cast=" + cast +
//                ", url=" + url +
//                '}';
//    }
//
//
//}
