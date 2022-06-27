package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.exceptions.UserNameExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserControllerAdvise extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNameExistsException.class)
    public ResponseEntity<Object> handleUsernameExistsException(){
        return ResponseEntity.badRequest().body("Username already exists");
    }
}
