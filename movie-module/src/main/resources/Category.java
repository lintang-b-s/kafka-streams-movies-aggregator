package com.kafkastreams.movieservice.api.response;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class Category {

    private int id;
    private String name;
}
