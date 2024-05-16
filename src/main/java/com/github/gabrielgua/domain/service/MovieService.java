package com.github.gabrielgua.domain.service;

import com.github.gabrielgua.domain.exception.MovieNotFoundException;
import com.github.gabrielgua.domain.model.Movie;
import com.github.gabrielgua.domain.repository.MovieRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MovieService {

    @Inject
    MovieRepository repository;

    @Transactional
    public void save(Movie movie) {
        repository.persist(movie);
    }

    public List<Movie> listAll() {
        return repository.listAll();
    }

    public Movie findById(Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @Transactional
    public void delete(Movie movie) {
        repository.delete(movie);
    }
}
