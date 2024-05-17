package com.github.gabrielgua.api.exception;

import com.github.gabrielgua.api.controller.ExceptionUtils;
import com.github.gabrielgua.domain.exception.MovieNotFoundException;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;

@Provider
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class MovieNotFoundHandler implements ExceptionMapper<MovieNotFoundException> {

    private final ExceptionUtils utils;

    @Override
    public Response toResponse(MovieNotFoundException e) {
        var status = Response.Status.NOT_FOUND.getStatusCode();
        var title = "Movie not found";

        var error = utils.createError(status, title, e.getMessage())
                .build();

        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(error)
                .build();
    }
}
