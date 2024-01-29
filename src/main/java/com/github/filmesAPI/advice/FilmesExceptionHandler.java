package com.github.filmesAPI.advice;

import com.github.filmesAPI.exceptions.CreateFilmeException;
import com.github.filmesAPI.exceptions.DeleteFilmeException;
import com.github.filmesAPI.exceptions.UpdateFilmeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FilmesExceptionHandler {

    @ExceptionHandler(CreateFilmeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String createFilmeException(CreateFilmeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(DeleteFilmeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String deleteFilmeException(DeleteFilmeException exception){
        return exception.getMessage();
    }

    @ExceptionHandler(UpdateFilmeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String updateFilmeException(UpdateFilmeException exception){
        return exception.getMessage();
    }


}
