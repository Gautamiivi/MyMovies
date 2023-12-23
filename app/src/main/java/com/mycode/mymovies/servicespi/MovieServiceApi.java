package com.mycode.mymovies.servicespi;

import com.mycode.mymovies.modell.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//step..3
public interface MovieServiceApi {
    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apikey);
}
