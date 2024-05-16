package com.github.gabrielgua.api.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;


@Getter
@Setter
public class MovieRequest {

    @NotBlank
    private String name;

    @NotNull
    private OffsetDateTime releaseDate;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    @NotBlank
    private String genre;

    @NotBlank
    private String producer;
}
