//step 6

package com.mycode.mymovies.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.mycode.mymovies.modell.Movies;
import com.mycode.mymovies.R;
import com.mycode.mymovies.databinding.ListItemBinding;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private ArrayList<Movies> moviesArrayList;
    private Context context;

    public MovieAdapter(ArrayList<Movies> moviesArrayList, Context context) {
        this.moviesArrayList = moviesArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding listItemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.list_item,
                        parent,
                        false);
        return new MyViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movies movies = moviesArrayList.get(position);
        holder.listItemBinding.setMovies(movies);

    }


    @Override
    public int getItemCount() {
        return moviesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    private  ListItemBinding listItemBinding;
    public MyViewHolder(ListItemBinding listItemBinding) {
        super(listItemBinding.getRoot());
        this.listItemBinding = listItemBinding;
        listItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
}
