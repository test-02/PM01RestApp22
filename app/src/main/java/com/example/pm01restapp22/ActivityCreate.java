package com.example.pm01restapp22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pm01restapp22.process.RestApiMethods;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ActivityCreate extends AppCompatActivity {

    String PostString = "";
    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        btnCreate = (Button) findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAuto();
            }
        });
    }

    private void CreateAuto(){
        PostString = RestApiMethods.ApiCreate;
        HashMap<String, String> parametros = new HashMap<>();

        parametros.put("modelo", "Mazda r3");
        parametros.put("marca", "Mazda");
        parametros.put("precio", "130000");
        parametros.put("year", "2022");

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.POST,
                PostString,
                new JSONObject(parametros),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray respuesta = response.getJSONArray("respuesta");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }
        );

        RequestQueue peticion = Volley.newRequestQueue(getApplicationContext());
        peticion.add(request);
    }
}