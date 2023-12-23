package com.mycode.mymovies.servicespi;

//step..4

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://api.themoviedb.org/3/";
    public static MovieServiceApi getService(){
        if (retrofit ==null ){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(MovieServiceApi.class);
    }
}
