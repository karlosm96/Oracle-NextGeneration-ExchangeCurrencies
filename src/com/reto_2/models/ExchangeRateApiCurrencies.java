package com.reto_2.models;

import com.google.gson.JsonObject;

public record ExchangeRateApiCurrencies(String base_code, JsonObject conversion_rates) {
}