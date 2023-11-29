package com.example.comp1011assignment2;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private String title;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genres;
    @SerializedName("overview")
    private String description;

    @SerializedName("release_date")
    private Date releaseDate;
    @SerializedName("poster_path")
    private String poster;

    public String getTitle() {
        return title;
    }

    public ArrayList<Integer> getGenres() {
        return genres;
    }

    public String getDescription() {
        return description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getPoster() {
        return poster;
    }
}
