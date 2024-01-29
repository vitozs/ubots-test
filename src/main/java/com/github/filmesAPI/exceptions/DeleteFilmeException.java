package com.github.filmesAPI.exceptions;

public class DeleteFilmeException extends RuntimeException{
    public DeleteFilmeException(String erro){
        super(erro);
    }
}
