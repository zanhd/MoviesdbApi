package com.zanhd.moviesdbapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.zanhd.moviesdbapi.adapter.RecyclerViewAdapter;
import com.zanhd.moviesdbapi.data.MovieListAsyncResponce;
import com.zanhd.moviesdbapi.model.Movie;
import com.zanhd.moviesdbapi.data.MovieBank;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    private List<Movie> moviesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.home_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        moviesList = new MovieBank().getAllMovies(new MovieListAsyncResponce() {
            @Override
            public void processFinished(ArrayList<Movie> movieArrayList) {
                //Log.d("Inside", "processFinished: " + movieArrayList);
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,movieArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });

    }

}