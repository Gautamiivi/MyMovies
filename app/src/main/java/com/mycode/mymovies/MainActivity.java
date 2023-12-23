package com.mycode.mymovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.mycode.mymovies.modell.Movies;
import com.mycode.mymovies.databinding.ActivityMainBinding;
import com.mycode.mymovies.view.MovieAdapter;
import com.mycode.mymovies.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movies> moviesArrayList;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ActivityMainBinding activityMainBinding;
    private MovieAdapter movieAdapter;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
                 getPopularMovies();
        swipeRefreshLayout=activityMainBinding.swapLayout;
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.black));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });

    }
    private void getPopularMovies(){
        mainActivityViewModel.getAllMovies().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                moviesArrayList = (ArrayList<Movies>) movies;
                displayMoviesInRecyclerView();
            }
        });
    }
    private void displayMoviesInRecyclerView(){
        recyclerView = activityMainBinding.recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        movieAdapter = new MovieAdapter(moviesArrayList,this);
        recyclerView.setAdapter(movieAdapter);

        movieAdapter.notifyDataSetChanged();

    }
}