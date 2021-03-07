package com.hackernews

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Toolbar
import com.android.volley.RequestQueue
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.jsoup.Jsoup

class MainActivity : Activity() {

    private var requestQueue: RequestQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_main)
        requestQueue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            "https://news.ycombinator.com",
            { response: String? ->
                Log.d("DEVELOP", response!!)
                val document = Jsoup.parse(response)
            }
        ) { error: VolleyError -> Log.e("DEVELOP", error.localizedMessage) }
        requestQueue?.add(stringRequest)
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setActionBar(toolbar)
    }
}