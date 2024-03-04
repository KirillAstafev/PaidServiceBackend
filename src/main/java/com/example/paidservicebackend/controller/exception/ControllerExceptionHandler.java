package com.example.paidservicebackend.controller.exception;

import com.example.paidservicebackend.controller.exception.message.ErrorMessage;
import com.example.paidservicebackend.exception.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage personNotFoundHandler(PersonNotFoundException exception) {
        return new ErrorMessage(exception.getMessage());
    }
}
