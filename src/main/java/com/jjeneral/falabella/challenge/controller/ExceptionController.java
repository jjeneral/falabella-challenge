package com.jjeneral.falabella.challenge.controller;

import com.jjeneral.falabella.challenge.exception.DuplicatedProductException;
import com.jjeneral.falabella.challenge.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, List<String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        log.error("Validation error", ex);
        List<String> validationErrors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return getErrorResponse(validationErrors);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, List<String>> handleProductNotFound(ProductNotFoundException ex) {
        log.error("Not found error", ex);
        List<String> errors = Collections.singletonList(ex.getMessage());
        return getErrorResponse(errors);
    }

    @ExceptionHandler(DuplicatedProductException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, List<String>> handleDuplicatedProduct(DuplicatedProductException ex) {
        log.error("Duplicated product error", ex);
        List<String> errors = Collections.singletonList(ex.getMessage());
        return getErrorResponse(errors);
    }
    @ExceptionHandler({Exception.class, RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Map<String, List<String>> handleOtherExceptions(Exception ex) {
        log.error("General Error", ex);
        List<String> errors = Collections.singletonList(ex.getMessage());
        return getErrorResponse(errors);
    }

    private Map<String, List<String>> getErrorResponse(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("errors", errors);
        return errorResponse;
    }

}
