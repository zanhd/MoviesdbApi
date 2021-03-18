package com.zanhd.moviesdbapi.data;

import com.zanhd.moviesdbapi.model.Movie;

import java.util.ArrayList;

public interface MovieListAsyncResponce {
    void processFinished(ArrayList<Movie> movieArrayList);
}
