package com.github.gabrielgua.api.exception;

import com.github.gabrielgua.api.controller.ExceptionUtils;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Provider
@RequiredArgsConstructor
@Produces(MediaType.APPLICATION_JSON)
public class ContraintViolationHandler implements ExceptionMapper<ConstraintViolationException> {

    private final ExceptionUtils utils;

    private String getFieldName(ConstraintViolation<?> violation) {
        String field = null;
        for (Path.Node node : violation.getPropertyPath()) {
            field = node.getName();
        }

        return field;
    }

    @Override
    public Response toResponse(ConstraintViolationException e) {
        var status = 422; //unprocessable entity
        var title = "Property Violation";
        var message = "One or more properties are incorrect";

        var errors = new HashMap<String, Object>();

        e.getConstraintViolations().forEach(f -> {
            errors.put(getFieldName(f), f.getMessage());
        });

        var error = utils.createError(status, title, message)
                .violations(errors)
                .build();

        return Response
                .status(status)
                .entity(error)
                .build();
    }

}
