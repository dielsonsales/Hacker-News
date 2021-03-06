package com.hackernews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends Activity {

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
            "https://news.ycombinator.com",
            response -> Log.d("DEVELOP", response),
            error -> Log.e("DEVELOP", error.getLocalizedMessage())
        );
        requestQueue.add(stringRequest);
    }
}
