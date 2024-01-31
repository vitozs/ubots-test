package com.github.filmesAPI.advice;

import com.github.filmesAPI.exceptions.CreateException;
import com.github.filmesAPI.exceptions.DeleteException;
import com.github.filmesAPI.exceptions.UpdateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CreateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String createFilmeException(CreateException exception){
        return exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(DeleteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String deleteFilmeException(DeleteException exception){
        return exception.getMessage();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UpdateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String updateFilmeException(UpdateException exception){
        return exception.getMessage();
    }


}
