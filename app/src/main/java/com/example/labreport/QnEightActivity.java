package com.example.labreport;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

public class QnEightActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<QnEightWeatherModel> list;
    QnEightWeatherAdapter adapter;

    String URL = "https://api.open-meteo.com/v1/forecast?latitude=27.7&longitude=85.3&current_weather=true";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_eight_activity);

        gridView = findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new QnEightWeatherAdapter(this, list);
        gridView.setAdapter(adapter);

        fetchWeather();
    }
    private void fetchWeather() {

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject current = response.getJSONObject("current_weather");

                            list.add(new QnEightWeatherModel("Temperature",
                                    current.getString("temperature") + " °C"));

                            list.add(new QnEightWeatherModel("Wind Speed",
                                    current.getString("windspeed") + " km/h"));

                            list.add(new QnEightWeatherModel("Time",
                                    current.getString("time")));

                            adapter.notifyDataSetChanged();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(QnEightActivity.this,
                                "Error fetching data", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);
    }
}
