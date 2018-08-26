package com.sathidov.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class forg extends AppCompatActivity {
    ArrayList<member> memberforg = new ArrayList<member>();

    EditText emilforg;
String emailforgtxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forg);
        Intent i=this.getIntent();
        memberforg= i.getParcelableArrayListExtra("array1");

    }

    public void enter(View view) {
        int t=0;
        emilforg = findViewById(R.id.emailfrog);
        emailforgtxt = emilforg.getText().toString();
        for (int j = 0; j < memberforg.size(); j++) {
            String memeami=memberforg.get(j).getemail();
            if (emailforgtxt.equals(memeami)) {
                String txt="";
                txt+=memberforg.get(j).getUesrname();
                txt+="\n";
                txt+=getString(R.string.passjava)+memberforg.get(j).getPasword();
                TextView txtcode=findViewById(R.id.txtcode);
                txtcode.setText(txt);
                t=1;
            }
        }
        if(t==0){
            Toast.makeText(this, R.string.notuesr, Toast.LENGTH_SHORT).show();
        }
    }
}
