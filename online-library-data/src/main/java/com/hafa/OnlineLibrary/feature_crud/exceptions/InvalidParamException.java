package com.hafa.OnlineLibrary.feature_crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidParamException extends RuntimeException {

    public InvalidParamException(String message) {
        super(message);
    }

    public InvalidParamException(String message, Throwable cause) {
        super(message, cause);
    }

}