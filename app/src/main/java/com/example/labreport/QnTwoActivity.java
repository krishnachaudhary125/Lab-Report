package com.example.labreport;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class QnTwoActivity extends AppCompatActivity {
    TextView data;
    String url = "https://dummyjson.com/users";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qn_two_activity);

        data = findViewById(R.id.data);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    JSONArray users = jsonObject.getJSONArray("users");

                    StringBuilder allFirstNames = new StringBuilder();
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject user = users.getJSONObject(i);
                        String firstName = user.getString("firstName");
                        allFirstNames.append(firstName).append("\n"); // each name in new line
                    }

                    data.setText(allFirstNames.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                data.setText("Error fetching data");
            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}
