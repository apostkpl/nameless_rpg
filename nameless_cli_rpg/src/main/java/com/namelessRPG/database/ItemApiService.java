package com.namelessRPG.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.List;

public class ItemApiService {
    
    // Base URL for your running Spring Boot API
    private static final String API_BASE_URL = "http://localhost:8080/api/v1/codex";
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public List<ItemData> fetchWeapons() {
        return fetchData("/weapons");
    }

    public List<ItemData> fetchPotions() {
        return fetchData("/potions");
    }

    private List<ItemData> fetchData(String endpoint) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_BASE_URL + endpoint))
                .GET()
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Use Gson to deserialize the JSON response body into a List of your existing ItemData DTOs
                return gson.fromJson(response.body(), new TypeToken<List<ItemData>>() {}.getType());
            } else {
                System.err.printf("Error fetching %s: API returned status %d\n", endpoint, response.statusCode());
                return Collections.emptyList();
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Network error: Could not connect to API at " + API_BASE_URL + e.getMessage());
            return Collections.emptyList();
        }
    }
}