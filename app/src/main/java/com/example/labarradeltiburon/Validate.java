package com.example.labarradeltiburon;

import android.util.Patterns;

import java.util.regex.Pattern;

public class Validate {
    public boolean validarNombre(String nombre){
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        return patron.matcher(nombre).matches() || nombre.length() > 30;
    }
    public boolean validarCorreo(String nombre){
        Pattern patron = Pattern.compile("[A-Za-z.@_-]+");
        return patron.matcher(nombre).matches() || nombre.length() > 30;
    }
    public boolean validadTelefono(String telefono){
        return Patterns.PHONE.matcher(telefono).matches();
    }
    public boolean esCorreoValido(String correo){
        return Patterns.EMAIL_ADDRESS.matcher(correo).matches();
    }

}
