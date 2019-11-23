package com.example.copiabarra;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validate {
    public boolean validarNombre(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Zá-úÁ-Ú]+$");
        return patron.matcher(nombre).matches() ||  nombre.length() >30;
    }
    public boolean validarCorreo(String correo){
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }
}
