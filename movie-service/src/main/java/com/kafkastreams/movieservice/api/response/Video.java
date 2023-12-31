package com.kafkastreams.movieservice.api.response;

import lombok.*;


@Setter
@Getter
@Builder
@NoArgsConstructor
public class Video {

    private int id;


    private String url;
    private String publicId;


    private Integer length;


    private String title;


    private String synopsis;

    private int movieId;

    public Video(int id, String url, String publicId, Integer length, String title, String synopsis, int movieId) {
        this.id = id;
        this.url = url;
        this.length = length;
        this.title = title;
        this.synopsis = synopsis;
        this.publicId = publicId;
        this.movieId= movieId;
    }
}
