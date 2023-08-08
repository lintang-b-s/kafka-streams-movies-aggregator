package com.kafkastreams.moviemodule;

import lombok.*;
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
