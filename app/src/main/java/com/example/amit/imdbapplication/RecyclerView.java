package com.example.amit.imdbapplication;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import ListBackgroundTask.BackTask1;
import ListBackgroundTask.BackTask2;
import ListBackgroundTask.BackTask3;
import ListBackgroundTask.BackTask4;
import ListBackgroundTask.BackgroundTask;

public class RecyclerView extends AppCompatActivity {
    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null&&networkInfo.isConnected())
        {
            toolbar=(Toolbar)findViewById(R.id.toolbar);

            if(toolbar!=null)
            {
                setSupportActionBar(toolbar);
                toolbar.setLogo(R.drawable.scene1);
                ActionBar actionBar=getSupportActionBar();
                actionBar.setDisplayUseLogoEnabled(true);
                actionBar.setDisplayShowTitleEnabled(false);

            }

            BackgroundTask backgroundTask=new BackgroundTask(this);
            backgroundTask.execute();

        }
        else
        {
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Network error..!!!!!")
                    .setMessage("Please Connect The Internet First...!!!!");
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            textView=(TextView)findViewById(R.id.text);
            textView.setVisibility(View.VISIBLE);
            /*Intent intent=new Intent(RecyclerView.this,MainActivity.class);
            startActivity(intent);*/

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.most_popular:
                BackTask1 backTask1=new BackTask1(this);
                backTask1.execute();
                break;
            case R.id.upcoming_movies:
                BackTask2 backTask2=new BackTask2(this);
                backTask2.execute();
                break;
            case R.id.latest_movies:
                BackTask1 back=new BackTask1(this);
                back.execute();
                break;
            case R.id.now_playing:
                BackTask3 backTask3=new BackTask3(this);
                backTask3.execute();
                break;
            case R.id.top_rated:
                BackTask4 backTask4=new BackTask4(this);
                backTask4.execute();
                break;
            case R.id.my_favorites:
                break;
            case R.id.my_watchlist:
                break;
            case R.id.refresh:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

