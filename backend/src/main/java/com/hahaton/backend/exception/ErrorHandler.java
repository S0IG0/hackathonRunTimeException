package com.hahaton.backend.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({
            ValidationException.class,
    })
    ResponseEntity<ErrorResponse> handleValidationExceptions(final ValidationException e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({
            IllegalArgumentException.class,
    })
    ResponseEntity<ErrorResponse> handleIllegalArgumentExceptions(final IllegalArgumentException e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler({
            ImageException.class,
    })
    ResponseEntity<ErrorResponse> handleImageExceptions(final IllegalArgumentException e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResponse> handleNotFoundExceptions(final NotFoundException e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            org.hibernate.exception.ConstraintViolationException.class,
            DataIntegrityViolationException.class,
            ConflictException.class
    })
    ResponseEntity<ErrorResponse> handleDatabaseExceptions(final ConflictException e) {
        log.error("Exception: " + e.getMessage(), e);
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.CONFLICT);
    }

}
