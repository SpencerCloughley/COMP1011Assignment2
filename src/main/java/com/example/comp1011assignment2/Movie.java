package com.example.comp1011assignment2;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private String title;
    @SerializedName("genre_ids")
    private ArrayList<Integer> genres;
    @SerializedName("overview")
    private String description;
    private double popularity;
    @SerializedName("release_date")
    private Date releaseDate;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("id")
    private int movieId;

    public String getTitle() {
        return title;
    }

    public ArrayList<Integer> getGenres() {
        return genres;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getReleaseDate() {
        // pulled conversion of Date to LocalDate from
        //https://www.baeldung.com/java-date-to-localdate-and-localdatetime
        return releaseDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public String getPoster() {
        //first half of the poster url
        //https://www.themoviedb.org/t/p/w600_and_h900_bestv2/
        return "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/" + poster;
    }

    public double getPopularity() {
        return popularity;
    }

    public int getMovieId() {
        return movieId;
    }
}
