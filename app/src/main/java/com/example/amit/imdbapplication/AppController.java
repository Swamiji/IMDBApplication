package com.example.amit.imdbapplication;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by Amit on 8/5/2017.
 */

public class AppController extends Application {
    public static final String TAG=AppController.class.getSimpleName();
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
    public static synchronized AppController getmInstance()
    {
        return mInstance;
    }
    public RequestQueue getRequestQueue()
    {
        if(requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }
    public ImageLoader getImageLoader()
    {
        getRequestQueue();
        if(imageLoader==null)
        {
            imageLoader=new ImageLoader(requestQueue,new BitmapCache());
        }
        return this.imageLoader;
    }
    public <T> void addToRequestQueue(Request<T>request,String tag)
    {
      request.setTag(TextUtils.isEmpty(tag) ? TAG :tag);
        getRequestQueue().add(request);
    }
    public <T> void addToRequestQueue(Request<T>request)
    {
       request.setTag(TAG);
        getRequestQueue().add(request);
    }
    public void CancelPendingRequest(Object tag)
    {
        if(requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }


}
