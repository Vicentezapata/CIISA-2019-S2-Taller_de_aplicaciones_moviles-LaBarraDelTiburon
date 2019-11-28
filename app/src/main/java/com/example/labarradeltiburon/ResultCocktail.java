package com.example.labarradeltiburon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultCocktail extends AppCompatActivity {
    TextView tvNameCocktail;
    String nameCockt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_cocktail);

        //REFERENCIAS
        tvNameCocktail = (TextView) findViewById(R.id.tvNameCocktail);
        nameCockt = getIntent().getStringExtra("nameCocktSelected");

        tvNameCocktail.setText(nameCockt);


    }
}
