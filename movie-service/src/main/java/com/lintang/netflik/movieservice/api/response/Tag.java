package com.lintang.netflik.movieservice.api.response;

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
