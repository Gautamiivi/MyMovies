package com.mycode.mymovies.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.mycode.mymovies.modell.Movies;
import com.mycode.mymovies.modell.MyRepository;

import java.util.List;

//step..7
public class MainActivityViewModel extends AndroidViewModel {
    private MyRepository myRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.myRepository = new MyRepository(application);
    }
    //Live data
    public LiveData<List<Movies>> getAllMovies(){
        return myRepository.getMutableLiveData();
    }

}
