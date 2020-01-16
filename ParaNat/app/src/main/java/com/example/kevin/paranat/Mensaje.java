package com.example.kevin.paranat;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Mensaje extends Activity {

    private ImageView mainImage;
    private AssetManager assetMan;
    private Drawable imgMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        mainImage = (ImageView) findViewById(R.id.ivMensaje);
        assetMan = Brain.getInstance().getAssetMan();
        InputStream input = null;
        try {
            input = assetMan.open(Brain.getInstance().getSelectedImg());
        } catch (IOException e) {
            e.printStackTrace();
        }
        imgMensaje= Drawable.createFromStream(input,null);
        mainImage.setBackground(imgMensaje);
    }
}