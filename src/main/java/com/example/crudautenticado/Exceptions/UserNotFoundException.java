package com.example.crudautenticado.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(long id) {
        super("Usuário de id: " + id + " não foi encontrado");
    }

    public UserNotFoundException() {
        super("Usuário não encontrado");
    }
}
