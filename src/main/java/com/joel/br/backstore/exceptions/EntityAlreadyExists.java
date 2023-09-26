package com.joel.br.backstore.exceptions;

public class EntityAlreadyExists extends  RuntimeException{

    public EntityAlreadyExists(String message) {
        super(message);
    }
}
