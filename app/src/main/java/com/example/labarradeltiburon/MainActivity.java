package com.example.labarradeltiburon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

public class MainActivity extends AppCompatActivity {
    TextView lblRegister;
    TextInputLayout tilCorreo,tilClave;
    Button btnRegister;
    Switch swRememberUser;

    //SHARED PREFERENCES
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias WIDGETS
        tilClave = (TextInputLayout) findViewById(R.id.til_clave);
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        lblRegister = (TextView) findViewById(R.id.txtRegister);
        btnRegister = (Button) findViewById(R.id.btnLogin);
        swRememberUser = (Switch) findViewById(R.id.swRememberUser);


        //INICIALIZAMOS LAS VARIABLES DE SHARED PREFERENCES
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedEditor = sharedPreferences.edit();
        String existMailUser = sharedPreferences.getString(getString(R.string.correo_usuario),"");
        //VERIFICAMOS SI EXISTE EL USUARIO EN NUESTRA VARIABLES DE PREFERENCIAS
        if(!existMailUser.equals("")){
            tilCorreo.getEditText().setText(existMailUser);
        }

        //INSTANCIAS DE EVENTOS ONCLICK (BUTONES O TEXTOS)
        lblRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarDatos()){
                    //ALMACENAMIENTO DE VARIABLE EN LOS ARCHIVOS DE PREFERENCIAS
                    if(swRememberUser.isChecked()){
                        sharedEditor.putString(getString(R.string.correo_usuario),tilCorreo.getEditText().getText().toString());
                        sharedEditor.commit();
                    }
                    else{
                        sharedEditor.putString(getString(R.string.correo_usuario),"");
                        sharedEditor.commit();
                    }
                    //INTENT Y CAMBIO DE PANTALLAS
                    //Intent intent = new Intent(v.getContext(),ListCocktailActivity.class);
                    Intent intent = new Intent(v.getContext(),ListCocktails.class);
                    String mailUser = tilCorreo.getEditText().getText().toString();
                    mailUser = mailUser.split("@")[0];
                    intent.putExtra("nameUser",mailUser);
                    startActivity(intent);
                }
            }
        });
    }
    private boolean validarDatos() {
        Validate validate = new Validate();
        String clave = tilClave.getEditText().getText().toString();
        String correo = tilCorreo.getEditText().getText().toString();

        boolean valido = validate.esCorreoValido(correo);
        if (valido) {
            // OK, se pasa a la siguiente acción
            tilCorreo.setError(null);
            return true;
            //Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show();
        }
        else{
            tilCorreo.setError("Nombre inválido");
            return false;
        }

    }

    //LIFECYCLE ACTIVITIES
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity","onRestart()");
    }
}
