package com.kafkastreams.moviemodule;
import lombok.*;
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
