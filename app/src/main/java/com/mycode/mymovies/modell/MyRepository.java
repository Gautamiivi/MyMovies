//step..5
//
package com.mycode.mymovies.modell;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.mycode.mymovies.R;
import com.mycode.mymovies.servicespi.MovieServiceApi;
import com.mycode.mymovies.servicespi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyRepository {
    private ArrayList<Movies> arrayList = new ArrayList<>();
    private MutableLiveData<List<Movies>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MyRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movies>> getMutableLiveData() {
        MovieServiceApi movieServiceApi = RetrofitInstance.getService();
        Call<Result> call = movieServiceApi.getPopularMovies
                (application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result = response.body();
                if (result !=null && result.getResults()!=null){
                    arrayList = (ArrayList<Movies>) result.getResults();
                    mutableLiveData.setValue(arrayList);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });


        return mutableLiveData;
    }
}
