package com.example.kevin.paranat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Kevin on 12/18/2017.
 */

class Brain {
    private static final Brain ourInstance = new Brain();

    static Brain getInstance() {
        return ourInstance;
    }

    private ArrayList<String> NombresArchivos;
    private AssetManager assetMan;
    private Context aplicationContext;
    private String selectedImg;

    private Brain() {
        NombresArchivos = new ArrayList<>();
        selectedImg = "";
    }

    public void setAssetMan()
    {
        assetMan = aplicationContext.getApplicationContext().getAssets();
    }

    public AssetManager getAssetMan() {
        return assetMan;
    }

    public void fillNombreArchivos()
    {
        ArrayList <Imagenes> myImagenes = new ArrayList<>();
        NombresArchivos.clear();
        try {
            for (int i = 0; i < assetMan.list("").length; i++)
            {
                //solo archivos que empiezan con mayuscula
                if (Character.isUpperCase(assetMan.list("")[i].charAt(0)))
                {
                    String tempString = assetMan.list("")[i];
                    String[] arr = tempString.split(" ");
                    arr[arr.length - 1] = arr[arr.length-1].replace(".jpg", "");
                    Integer posicion = Integer.valueOf(arr[arr.length - 1]);
                    Imagenes tempImg = new Imagenes(tempString,posicion);
                    myImagenes.add(tempImg);
                }
            }
            //ordenar
            String[] cloneAndSort = new String[16];
            for (int m = 0; m < cloneAndSort.length; m++)
            {
                cloneAndSort [myImagenes.get(m).getPosicion()] = myImagenes.get(m).getNombre();
            }

            //de array a arraylist
            for (int i =0; i < cloneAndSort.length; i++)
            {
                NombresArchivos.add(cloneAndSort[i]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setAplicationContext(Context aplicationContext) {
        this.aplicationContext = aplicationContext;
    }

    public ArrayList<String> getNombresArchivos() {
        return NombresArchivos;
    }

    public String getSelectedImg() {
        return selectedImg;
    }

    public void setSelectedImg(String selectedImg) {
        this.selectedImg = selectedImg;
    }
}
