package com.example.currentweather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CityFinderActivity extends AppCompatActivity {
    private RelativeLayout seeTheWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_finder);

        final EditText searchCity=findViewById(R.id.searchCity);
        ImageView backButton=findViewById(R.id.backButton);
        seeTheWeather = findViewById(R.id.seeTheWeather);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ///keyboard ei enter key tahole kuno extra button er dorkar nai
        searchCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String newCity= searchCity.getText().toString();
                Intent intent=new Intent(CityFinderActivity.this,MainActivity.class);
                intent.putExtra("City",newCity);
                startActivity(intent);
                return false;
            }
        });

        seeTheWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (searchCity.getText().toString().equals(""))
                {
                    Toast.makeText(CityFinderActivity.this,"Please Enter The City Name First",Toast.LENGTH_LONG).show();
                }

                else {
                    String newCity = searchCity.getText().toString();
                    Intent intent = new Intent(CityFinderActivity.this, MainActivity.class);
                    intent.putExtra("City", newCity);
                    startActivity(intent);
                }
            }
        });
    }


}