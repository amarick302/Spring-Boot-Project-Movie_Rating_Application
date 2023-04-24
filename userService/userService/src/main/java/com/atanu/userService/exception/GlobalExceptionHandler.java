package com.atanu.userService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> error=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((err)->{
            String fieldName=((FieldError)err).getField();
            String message=err.getDefaultMessage();
            error.put(fieldName,message);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
