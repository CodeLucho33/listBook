package com.example.listBooks.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class GetDataApi {
    public String getDataApi(String url) {
        //For url strict use newHttpClient without followRedirections()
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(20))
                .header("Accept", "application/json")
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //Show details about request
            System.out.println("Status code: " + response.statusCode());

            if (response.statusCode() == 301 || response.statusCode() == 302){
                String newUrl = response.headers().firstValue("Location").orElse("");
                getDataApi(newUrl);
            }
            return response.body();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al consumir la API", e);
        }
}

}
