package com.github.gabrielgua.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class MovieResponse {

    private Long id;
    private String name;
    private OffsetDateTime releaseDate;
    private int rating;
    private String genre;
    private String producer;
    private String classification;
}
