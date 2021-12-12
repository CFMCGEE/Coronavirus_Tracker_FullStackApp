package com.coronavirustracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GlobalException extends RuntimeException {

    public GlobalException() {

    }

    public GlobalException(String message) {
        super(message);
    }

}
