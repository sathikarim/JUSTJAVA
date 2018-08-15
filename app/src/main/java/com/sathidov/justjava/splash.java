package com.sathidov.justjava;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       ImageView img=findViewById(R.id.imgicon);
        AnimationDrawable animimg = (AnimationDrawable) img.getBackground();
        animimg.start();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent i=new Intent(splash.this,login.class);
                startActivity(i);
                finish();
            }
        }, 4700);
    }
}
