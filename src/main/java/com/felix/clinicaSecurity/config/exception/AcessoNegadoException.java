package com.felix.clinicaSecurity.config.exception;

public class AcessoNegadoException extends RuntimeException{

    public AcessoNegadoException(String message){
        super(message);
    }
}
