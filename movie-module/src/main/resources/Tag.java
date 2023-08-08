package com.kafkastreams.movieservice.api.response;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tag {
    private int id;
    private String name;
}
