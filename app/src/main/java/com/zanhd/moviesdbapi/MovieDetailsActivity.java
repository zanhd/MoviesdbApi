package com.zanhd.moviesdbapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.zanhd.moviesdbapi.model.Movie;

public class MovieDetailsActivity extends AppCompatActivity {

    TextView titleTextView;
    TextView idTextView;
    TextView overviewTextView;
    TextView languageTextView;
    TextView releaseDateTextView;
    TextView popularityTextView;
    TextView adultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        titleTextView = findViewById(R.id.movie_title);
        idTextView = findViewById(R.id.movie_id);
        overviewTextView  = findViewById(R.id.movie_overview);
        languageTextView = findViewById(R.id.movie_language);
        releaseDateTextView = findViewById(R.id.movie_release_date);
        popularityTextView = findViewById(R.id.movie_popularity);
        adultTextView = findViewById(R.id.movie_adult);

        Movie movie = Movie.getInstance();

        titleTextView.setText(String.format("Title : %s", movie.getTitle()));
        idTextView.setText(String.format("Id : %d", movie.getId()));
        overviewTextView.setText(String.format("Overview : %s", movie.getOverview()));
        languageTextView.setText(String.format("Language : %s", movie.getLangauge()));
        releaseDateTextView.setText(String.format("Release Date : %s", movie.getReleaseDate()));
        popularityTextView.setText(String.format("Popularity :%s", movie.getPopularity()));
        adultTextView.setText(String.format("Adult :%s", movie.isAdult()));
    }
}