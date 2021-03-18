package com.zanhd.moviesdbapi.data;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.zanhd.moviesdbapi.controller.AppController;
import com.zanhd.moviesdbapi.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MovieBank {
    ArrayList<Movie> movieArrayList = new ArrayList<>();
    String url = "https://api.themoviedb.org/3/movie/popular?api_key=4e44d9029b1270a757cddc766a1bcb63&language=en-US&page=1";

    public List<Movie> getAllMovies(final MovieListAsyncResponce callBack) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("results");

                    for(int i = 0; i < jsonArray.length() ;i++) {
                        try {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                Movie movie = new Movie();
                                movie.setAdult(jsonObject.getBoolean("adult"));
                                movie.setId(jsonObject.getInt("id"));
                                movie.setLangauge(jsonObject.getString("original_language"));
                                movie.setTitle(jsonObject.getString("title"));
                                movie.setOverview(jsonObject.getString("overview"));
                                movie.setPopularity(jsonObject.getDouble("popularity"));
                                movie.setPosterPath(jsonObject.getString("poster_path"));
                                movie.setReleaseDate(jsonObject.getString("release_date"));

                                movieArrayList.add(movie);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(callBack != null) callBack.processFinished(movieArrayList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Json Error", "onErrorResponse: " + error.getLocalizedMessage());
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest);
        return movieArrayList;
    }
}
