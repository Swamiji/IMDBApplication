package ListBackgroundTask;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.*;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.amit.imdbapplication.MovieAdapter;
import com.example.amit.imdbapplication.MovieInformation;
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
import java.util.ArrayList;

/**
 * Created by Amit on 8/4/2017.
 */

public class BackTask2 extends AsyncTask<Void,MovieInformation,String> {
    android.support.v7.widget.RecyclerView recyclerView;
    android.support.v7.widget.RecyclerView.Adapter adapter;
    android.support.v7.widget.RecyclerView.LayoutManager layoutManager;
    ArrayList<MovieInformation> arrayList=new ArrayList<>();
    String json_string="http://api.themoviedb.org/3/movie/upcoming?api_key=8496be0b2149805afa458ab8ec27560c";
    Context context;
    Activity activity;
    ProgressDialog progressdialog;
    public BackTask2(Context context) {
        this.context = context;
        activity=(Activity)context;
    }
    @Override
    protected void onPreExecute() {
        recyclerView=(android.support.v7.widget.RecyclerView)activity.findViewById(R.id.recyclerview);
        layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setVisibility(View.VISIBLE);
        adapter=new MovieAdapter(arrayList,context);
        recyclerView.setAdapter(adapter);
        progressdialog=new ProgressDialog(context);
        progressdialog.setTitle("Please wait..!!!!");
        progressdialog.setMessage("List is Loading...");
        progressdialog.setIndeterminate(true);
        progressdialog.setCancelable(false);
        progressdialog.show();

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url=new URL(json_string);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder=new StringBuilder();
            String line=" ";
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line+"\n");
            }
            String json_string=stringBuilder.toString().trim();
            Log.d("JSON_STRING",json_string);
            JSONObject jsonObject=new JSONObject(json_string);
            JSONArray jsonArray=jsonObject.getJSONArray("results");
            int count=0;
            while (count<jsonArray.length())
            {
                JSONObject JO=jsonArray.getJSONObject(count);
                count++;
                MovieInformation movieInformation=new MovieInformation(JO.getString("title"),JO.getString("release_date"),
                        JO.getInt("vote_count"),JO.getDouble("vote_average"),JO.getDouble("popularity"),JO.getString("poster_path"),JO.getDouble("popularity"));
                publishProgress(movieInformation);
                Thread.sleep(500);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "List is successfully loading..!!!!!";
    }

    @Override
    protected void onProgressUpdate(MovieInformation... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(context,result,Toast.LENGTH_SHORT).show();
        progressdialog.dismiss();
    }
}

