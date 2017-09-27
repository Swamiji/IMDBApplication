package com.example.amit.imdbapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.amit.imdbapplication.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    NetworkImageView movieImage,posterImage,cast_Image,Crew_Image;
    //ImageView movieImage;
    TextView MovieTitle,description,releaseDate,Budget,Revenue,Status,overview;
    TextView vote_count,vote_avg;
    TextView Cast_name,Cast_Character;
    TextView Crew_name,Crew_Character;
    TextView TrailersText;
    RatingBar ratingBar1,ratingBar2;
    ImageLoader imageLoader=AppController.getmInstance().getImageLoader();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity_layout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(toolbar!=null) {
            setSupportActionBar(toolbar);
            toolbar.setLogo(R.drawable.scene1);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        //movieImage=(ImageView) findViewById(R.id.networkImage);
        movieImage=(NetworkImageView)findViewById(R.id.networkImage);
        posterImage=(NetworkImageView)findViewById(R.id.poster);
        cast_Image=(NetworkImageView)findViewById(R.id.cast_image);
        Crew_Image=(NetworkImageView)findViewById(R.id.crew_image);
        MovieTitle=(TextView)findViewById(R.id.MOVIE_TITLE);
        description=(TextView)findViewById(R.id.descrip);
        releaseDate=(TextView)findViewById(R.id.release);
        Budget=(TextView)findViewById(R.id.budget);
        Revenue=(TextView)findViewById(R.id.revenu);
        Status=(TextView)findViewById(R.id.status);
        overview=(TextView)findViewById(R.id.Overview);
        vote_count=(TextView)findViewById(R.id.VOTE_COUNT);
        vote_avg=(TextView)findViewById(R.id.VOTE_AVG);
        Cast_name=(TextView)findViewById(R.id.cast_name);
        Cast_Character=(TextView)findViewById(R.id.cast_Character);
        Crew_name=(TextView)findViewById(R.id.crew_name);
        Crew_Character=(TextView)findViewById(R.id.crew_Character);
        TrailersText=(TextView)findViewById(R.id.trailer);
        ratingBar1=(RatingBar)findViewById(R.id.ratingBar);
        ratingBar2=(RatingBar)findViewById(R.id.ratingBar2);
        Intent intent=getIntent();
        MovieTitle.setText(intent.getStringExtra("title"));
        releaseDate.setText(intent.getStringExtra("release_date"));
        //ratingBar1.setRating((float) intent.getDoubleExtra("popularity",0.0f));
        //vote_count.setText(intent.getIntExtra("vote_count",0));
        //vote_avg.setText((int) intent.getDoubleExtra("vote_avg",0.0d));

        //new Json_Movie_Details().execute();
    }
    /*public class Json_Movie_Details extends AsyncTask<Void,Void,Void>{
        Intent intent=getIntent();
        String id=intent.getStringExtra("MOVIE_ID");
        String URL_mDetails="http://api.themoviedb.org/3/movie/"+id+"?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
        //String URL_mDetails="http://api.themoviedb.org/3/movie/now_playing?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
        String URL_mPosters="http://api.themoviedb.org/3/movie"+id+"/images?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
        String URL_mTrailers="http://api.themoviedb.org/3/movie"+id+"/videos?api_key=f47dd4de64c6ef630c2b0d50a087cc33";
        String movie_image1=" ";
        int new_vote_count;
        String str_movieImage, str_title, str_description, str_date, str_budget, str_revenue, str_status,
                str_vote_average, str_vote_count, str_overview, users;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url=new URL(URL_mDetails);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String line=" ";
                StringBuilder stringBuilder=new StringBuilder();
                while ((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }
                String json_string=stringBuilder.toString().trim();
                Log.d("Details",json_string);
                JSONObject jsonObject=new JSONObject(json_string);
                JSONArray jsonArray=jsonObject.getJSONArray("results");
                int count=0;
                while (count<jsonArray.length())
                {
                    JSONObject JO=jsonArray.getJSONObject(count);
                    str_title=JO.getString("title");
                    count++;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            MovieTitle.setText(str_title);
            super.onPostExecute(aVoid);
        }

    }*/
}
