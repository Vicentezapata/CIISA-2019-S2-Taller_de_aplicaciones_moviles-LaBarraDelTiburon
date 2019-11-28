package com.example.labarradeltiburon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegisterCocktail extends AppCompatActivity {
    String [] bases,segundaBases,jugos;
    Spinner spBase,spSgBase,spJugo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_cocktail);

        //CREAMOS EL VECTOR DE VALORES Y LO POBLAMOS
        bases = new String[] {"Tequila","Pisco","Ron","Ron Blanco","Ron Dorado"};
        segundaBases = new String[] {"Vodka","Whiskey","Pisco","Triple Sec"};
        jugos = new String[] {"Limon","Manzana","Pera","Frutilla","Frambuesa","Melon"};
        //CREAMOS EL ADAPTADOR
        ArrayAdapter<String> adaptadorBase,adaptadorSGBase,adaptadorJugos;
        adaptadorBase = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bases);
        adaptadorSGBase = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,segundaBases);
        adaptadorJugos = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,jugos);




        spBase = (Spinner) findViewById(R.id.spBase);
        spSgBase = (Spinner) findViewById(R.id.spSgBase);
        spJugo = (Spinner) findViewById(R.id.spJugo);
        spBase.setAdapter(adaptadorBase);
        spSgBase.setAdapter(adaptadorSGBase);
        spJugo.setAdapter(adaptadorJugos);
        
    }
}
