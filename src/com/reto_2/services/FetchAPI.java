package com.reto_2.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class FetchAPI {

    public FetchAPI(){}

    public static String fetchData(String url){
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body().toString();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
