package com.example.labarradeltiburon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListCocktails extends AppCompatActivity {
    TextView  txtNameUser;
    String [] cockteles;
    FloatingActionButton fabAdd;
    ListView lvCocktails;
    RecyclerView rcvCocktails;
    ArrayList<String> listCocktails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cocktails);

        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        lvCocktails = (ListView) findViewById(R.id.listadoDeRecetas);

        rcvCocktails = (RecyclerView) findViewById(R.id.rcvCocktails);
        rcvCocktails.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        //OBTENEMOS VARIABLE DE NUETRA ACTIVIDAD ANTERIOR
        String nameUser = getIntent().getStringExtra("nameUser");
        //ASIGNAREMOS DICHA VARIABLE A EL TextView generado
        txtNameUser = (TextView) findViewById(R.id.nameUser);
        txtNameUser.setText(nameUser);

        //CREAMOS EL VECTOR DE VALORES Y LO POBLAMOS
        cockteles = new String[] {"Tequila Margarita","Pisco Sour","Mojito","Mojito Frambuesa","Mojito Mango","Old Fashioned","Ruso Negro","Ruso Blanco","Daiquiri","Daiquiri frambuesa","Blue Hawaii","Caipirinha","Long Island Iced Tea","Bahama Mama","Mojito Royal","Manhattan","Zombie","Negroni","Paloma","Farnell"};
        //CREAMOS EL ADAPTADOR
        ArrayAdapter<String> adaptador;
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cockteles);

        //CREAMOS EL ADAPTADOR PARA EL RECYCLER VIEW Y LO POBLAMOS CON NUESTRO VECTOR DE COCTELES CREADOS PARA LISTVIEWS
        listCocktails = new ArrayList<String>();
        for (int i = 0; i < cockteles.length; i++){
            listCocktails.add(cockteles[i]);
        }
        AdapterDatosCocktails adapterDatosCocktails = new AdapterDatosCocktails(listCocktails);
        rcvCocktails.setAdapter(adapterDatosCocktails);


        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);
        //EVENTO CLICK PARA EL BOTON EXPANDIR MENU
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegisterCocktail.class);
                startActivity(intent);
            }
        });



        lvCocktails.setAdapter(adaptador);
        lvCocktails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nombreCoctel = cockteles[position];
                //Toast.makeText(view.getContext(),"position: "+position+"nombre: "+nombreCoctel, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(),ResultCocktail.class);
                intent.putExtra("nameCocktSelected",nombreCoctel);
                startActivity(intent);
            }
        });



    }
}
