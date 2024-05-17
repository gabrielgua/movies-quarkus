package com.github.gabrielgua.api.controller;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Map;

@ApplicationScoped
public class ExceptionUtils {

    public Error.ErrorBuilder createError(int status, String title, String message) {
        return Error.builder()
                .status(status)
                .message(message)
                .title(title);
    }
}
