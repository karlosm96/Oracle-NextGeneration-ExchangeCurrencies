package com.reto_2.customeExceptions;

public class NegativeCurrencyAmountException {
    private String message;

    public NegativeCurrencyAmountException(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
