package com.reto_2.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reto_2.customeExceptions.LengthCurrencyCodeException;

import java.util.Map;
import java.time.LocalDate;

public class Currency{
    private String baseCurrency;
    private Map<String, Double> conversionRates;
    private double amount;
    private String secondCurrencie;
    private double exchangeRate;
    private double total;

    public Currency(ExchangeRateApiCurrencies newExchangeRateApiCurrencies){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        this.baseCurrency = newExchangeRateApiCurrencies.base_code();
        this.conversionRates = gson.fromJson(newExchangeRateApiCurrencies.conversion_rates(), Map.class);
    }

    public void exchangeCurrency(double amount, String secondCurrency){
        if (secondCurrency.length() != 3){
            throw new LengthCurrencyCodeException("Error: El formato de la moneda es invalido");
        }
        if(amount == 0){
            throw new NegativeArraySizeException("Error: el monto ingresado no es valido");
        }

        this.amount = amount;
        this.secondCurrencie = secondCurrency.toUpperCase();
        this.exchangeRate = this.conversionRates.get(this.secondCurrencie);
        this.total = this.amount * this.exchangeRate;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public String getSecondCurrencie() {
        return secondCurrencie;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "************************** " + "\n" +
                LocalDate.now() + "\n" +
                "Cambio{" + "\n" +
                "  Moneda= " + this.baseCurrency + "\n" +
                "  Tasa de cambio= " + this.conversionRates.get(this.secondCurrencie) + "\n" +
                "  Monto= " + this.amount + "\n" +
                "  Moneda de cambio= " + this.secondCurrencie + "\n" +
                "  Monto final= " + String.format("%.3f",this.total) + " " + this.secondCurrencie + '}' + "\n" +
                "************************* " + "\n";
    }
}
