package com.hackernews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toolbar;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MainActivity extends Activity {

    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);
        requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(
            "https://news.ycombinator.com",
            response -> {
                Log.d("DEVELOP", response);
                Document document = Jsoup.parse(response);
            },
            error -> Log.e("DEVELOP", error.getLocalizedMessage())
        );
        requestQueue.add(stringRequest);

        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setActionBar(toolbar);
    }
}
