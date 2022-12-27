package com.hafa.OnlineLibrary.feature_crud.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private Message handleMessageNotFound(NotFoundException e, HttpServletRequest request) {
        Message message = new Message();

        message.setTimestamp(String.valueOf(getTimeStamp()));
        message.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        message.setStatus(HttpStatus.NOT_FOUND.value());
        message.setMessage(e.getMessage());
        message.setPath(String.valueOf(request.getRequestURI()));
        return message;
    }

    @ExceptionHandler(InvalidParamException.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    private Message handleMessageInvalidRoleType(InvalidParamException e, HttpServletRequest request) {
        Message message = new Message();
        message.setTimestamp(String.valueOf(getTimeStamp()));
        message.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        message.setStatus(HttpStatus.BAD_REQUEST.value());
        message.setMessage(e.getMessage());
        message.setPath(String.valueOf(request.getRequestURI()));
        return message;
    }

    private LocalDateTime getTimeStamp() {
        return LocalDateTime.now();
    }
}
