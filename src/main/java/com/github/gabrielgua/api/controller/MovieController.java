package com.github.gabrielgua.api.controller;

import com.github.gabrielgua.api.mapper.MovieMapper;
import com.github.gabrielgua.api.model.MovieRequest;
import com.github.gabrielgua.domain.service.MovieService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.RestPath;

import java.net.URI;

@Path("/movies")
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class MovieController {

    private final MovieMapper mapper;
    private final MovieService service;

    @GET
    public Response listAll() {
        return Response.ok(mapper.toCollectionResponse(service.listAll())).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@RestPath Long id) {
        return Response.ok(mapper.toResponse(service.findById(id))).build();
    }

    @POST
    public Response save(@Valid MovieRequest request) {
        var movie = mapper.toEntity(request);
        service.save(movie);
        return Response
                .created(URI.create("/movies/" + movie.getId()))
                .entity(movie)
                .build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@Valid MovieRequest request, @RestPath Long id) {
        var movie = service.findById(id);
        mapper.copyToEntity(request, movie);
        return Response.ok(movie).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(Long id) {
        var movie = service.findById(id);
        service.delete(movie);
        return Response.ok().build();
    }
























}
