package com.project.learn_refresh_jwt.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidSubjectsException.class)
    @ResponseBody
    public ResponseEntity<String> handleInvalidSubjectsException(InvalidSubjectsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException ex) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
