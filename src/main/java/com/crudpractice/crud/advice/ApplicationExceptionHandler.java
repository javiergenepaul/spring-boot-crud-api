package com.crudpractice.crud.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleInvalidArgument(ConstraintViolationException ex) {
        Map<String, String> errorMap = new HashMap<>();
        String errorMessage = new ArrayList<>(ex.getConstraintViolations()).get(0).getMessage();
        ex.getConstraintViolations().forEach(error -> {
            errorMap.put(error.getPropertyPath().toString(), error.getMessage());
        });
        return errorMap;
    }
}
