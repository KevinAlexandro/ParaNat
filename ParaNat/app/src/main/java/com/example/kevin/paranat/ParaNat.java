package com.example.kevin.paranat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class ParaNat extends Activity {

    private ListView mainList;
    private ArrayList<String> archivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carga la actividad
        setContentView(R.layout.activity_para_nat);
        //setea el solteron
        Brain.getInstance().setAplicationContext(getApplicationContext());
        Brain.getInstance().setAssetMan();
        Brain.getInstance().fillNombreArchivos();
        archivos = Brain.getInstance().getNombresArchivos();
        for (int k = 0; k < archivos.size(); k++) {
            String archivo = archivos.get(k);
            archivo = archivo.replace(".jpg", "");
            archivo = archivo.replace(String.valueOf(k),"");
            archivos.set(k, archivo);
        }
        //se enlazan los componentes
        mainList = (ListView) findViewById(R.id.lvOpciones);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.font_layout, R.id.textLayout, archivos);
        mainList.setAdapter(myAdapter);
    }

    public void showImage(View v) {
        final Button b = (Button) v;
        String name = (String) b.getText();
        Integer index = archivos.indexOf(name);
        Log.d("TAG",  index.toString());
        Brain.getInstance().setSelectedImg(name + index.toString()+".jpg");
        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        performIntent();
    }

    public void showRandomImage(View v)
    {
        Random myRandGen = new Random();
        int loteria = myRandGen.nextInt(archivos.size());
        String imagen = archivos.get(loteria);
        Brain.getInstance().setSelectedImg(imagen + String.valueOf(loteria)+".jpg");
        Toast.makeText(getApplicationContext(), imagen, Toast.LENGTH_SHORT).show();
        performIntent();
    }

    public void performIntent()
    {
        Intent nextActivity = new Intent(this, Mensaje.class);
        startActivity(nextActivity);
    }
}