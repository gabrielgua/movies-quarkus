package com.github.gabrielgua.api.mapper;

import com.github.gabrielgua.api.model.MovieRequest;
import com.github.gabrielgua.api.model.MovieResponse;
import com.github.gabrielgua.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MovieMapper {

    @Mapping(target = "id", ignore = true)
    public Movie toEntity(MovieRequest request);

    public MovieResponse toResponse(Movie movie);

    public List<MovieResponse> toCollectionResponse(List<Movie> movies);

    void copyToEntity(MovieRequest request, @MappingTarget Movie movie);
}
