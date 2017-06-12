package info.androidhive.firebase.mRecycler;


import android.content.Context;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


import info.androidhive.firebase.R;
import info.androidhive.firebase.mData.Movie;
import info.androidhive.firebase.mPicasso.PicassoClient;


/**
 * Created by Oclemmy on 4/12/2016 for ProgrammingWizards Channel.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context c;



    ArrayList<Movie> movies;
    public MyAdapter(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
    }









    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);

        MyHolder holder=new MyHolder(v);




        return holder;
    }
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nameTxt.setText(movies.get(position).getName());
        PicassoClient.downloadImage(c,movies.get(position).getUrl(),holder.img);
        holder.branchTxt.setText(movies.get(position).getbranch());
        holder.numberTxt.setText(movies.get(position).getnumber());
//        holder.dealsText.setText(movies.get(position).getdeals());


    }
    @Override
    public int getItemCount() {
        return movies.size();
    }






}