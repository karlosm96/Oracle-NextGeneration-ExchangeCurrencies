package com.reto_2.customeExceptions;

public class LengthCurrencyCodeException extends RuntimeException{
    private String message;

    public LengthCurrencyCodeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
