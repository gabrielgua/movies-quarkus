package com.github.gabrielgua.domain.exception;

public class MovieNotFoundException extends BusinessException {

    public MovieNotFoundException(Long id) {
        super(String.format("movie not found for id: %s", id));
    }

}
