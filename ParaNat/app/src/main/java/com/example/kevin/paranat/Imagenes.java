package com.example.kevin.paranat;

/**
 * Created by Kevin on 12/18/2017.
 */

public class Imagenes
{

    private String Nombre;
    private int posicion;
    public Imagenes()
    {
        posicion = 0;
        Nombre = "";
    }

    public Imagenes(String nombre, int posicion)
    {
        Nombre = nombre;
        this.posicion = posicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPosicion() {
        return posicion;
    }
}
