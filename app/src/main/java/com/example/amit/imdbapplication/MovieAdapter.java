package com.example.amit.imdbapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import ListBackgroundTask.BackTask1;
import ListBackgroundTask.BackgroundTask;


/**
 * Created by Amit on 8/3/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.RecyclerViewHolder> {
    ArrayList<MovieInformation>arrayList=new ArrayList<>();
    Context context;
    ImageLoader imageLoader= AppController.getmInstance().getImageLoader();
    public MovieAdapter(ArrayList<MovieInformation>arrayList,Context context)
    {
        this.arrayList=arrayList;
        this.context=context;

    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view,context,arrayList);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        MovieInformation movieInformation=arrayList.get(position);
        holder.title.setText(movieInformation.getTitle());
        holder.releasedate.setText(movieInformation.getReleasedate());
        holder.votecount.setText(Integer.toString(movieInformation.getVotecount())+" users...");
        holder.voteavg.setText("("+Double.toString(movieInformation.getVoteavg())+"/10) voted by ");
        holder.ratingBar.setRating((float) movieInformation.getPopularity()/2);
        holder.ratingbar.setRating((float) movieInformation.getPopularity1()/8);
        imageLoader=AppController.getmInstance().getImageLoader();
        holder.movieimage.setImageUrl("http://image.tmdb.org/t/p/w500"+movieInformation.getImg(),imageLoader);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

     static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView title,releasedate,votecount,voteavg;
        NetworkImageView movieimage;
        RatingBar ratingBar,ratingbar;
         Context context;
         ArrayList<MovieInformation>arrayList=new ArrayList<>();
        public RecyclerViewHolder(View itemView, final Context context, final ArrayList<MovieInformation>arrayList) {
            super(itemView);
            this.context=context;
            this.arrayList=arrayList;
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    MovieInformation movie=arrayList.get(position);
                    //String id="http://api.themoviedb.org/3/movie/now_playing?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
                       Intent intent=new Intent(context.getApplicationContext(),MainActivity.class);
                        intent.putExtra("title",movie.getTitle());
                        intent.putExtra("movie_image",movie.getImg());
                         intent.putExtra("release_date",movie.getReleasedate());
                         intent.putExtra("popularity",movie.getPopularity());
                    intent.putExtra("vote_count",movie.getVotecount()+"users..");
                    intent.putExtra("vote_avg",movie.getVoteavg());
                        context.startActivity(intent);


                }
            });
            title=(TextView)itemView.findViewById(R.id.title);
            releasedate=(TextView)itemView.findViewById(R.id.releaseDate);
            votecount=(TextView)itemView.findViewById(R.id.users);
            voteavg=(TextView)itemView.findViewById(R.id.voteavg);
            movieimage=(NetworkImageView) itemView.findViewById(R.id.imagemovie);
            ratingBar=(RatingBar)itemView.findViewById(R.id.ratingBar2);
            ratingbar=(RatingBar)itemView.findViewById(R.id.ratingbar3);

        }
    }
}
