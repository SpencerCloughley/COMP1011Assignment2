package com.example.comp1011assignment2;

import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIUtility {
    public static NowPlaying callNowPlaying() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String uri = "https://api.themoviedb.org/3/movie/now_playing?language=en-US";
        //https://api.themoviedb.org/3/movie/now_playing?language=en-US
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri))
                .GET()
                .header("accept", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5MzVkNWFkOGUxNTVkODkyZmZlYWFhNWM3YTlhMDMxMSIsInN1YiI6IjY1NTU2YWZjNTM4NjZlMDBlMjkyZDkwZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.DhtWhM3Gqy882NSivSfJ72J3DKU_RmMZdDGS-g4zFJc")
                .build();

        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse
                                                   .BodyHandlers
                                                  .ofFile(Paths.get("movies.json")));
        HttpResponse<String> response = client.send(httpRequest, HttpResponse
                .BodyHandlers.ofString());
        Gson gson = new Gson();
        return gson.fromJson(response.body(), NowPlaying.class);
    }
}
