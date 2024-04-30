package com.reto_2.services;

import com.reto_2.customeExceptions.LengthCurrencyCodeException;

public class CreateExchangeRateURL {

    CreateExchangeRateURL(){}

    public static String createURL(String apiKey, String currency){
        if(currency.length() != 3){
            throw new LengthCurrencyCodeException("Error: El formato de la moneda es invalido");
            //Agregar la excepcion de ingresar un numero
        }else {
            return "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/"+ currency.toUpperCase();
        }
    }
}
