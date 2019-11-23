package com.example.copiabarra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout tilCorreo,tilClave;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias TILS
        tilCorreo = (TextInputLayout) findViewById(R.id.til_correo);
        tilClave =  (TextInputLayout) findViewById(R.id.til_clave);
        btnLogin = (Button)  findViewById(R.id.btnLogin);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarDatos()){
                    Intent intent = new Intent(v.getContext(),ListCocktails.class);
                    startActivity(intent);
                }


            }
        });


    }

    private boolean validarDatos(){
        Validate validate = new Validate();
        String clave = tilClave.getEditText().getText().toString();
        String correo = tilCorreo.getEditText().getText().toString();
        boolean valido = validate.validarCorreo(correo);
        boolean validoClave = validate.validarCorreo(correo);

        if(valido){
            tilCorreo.setError("null");
            return true;

        }else{
            tilCorreo.setError("Correo invalido");
            return false;
        }

    }
}
