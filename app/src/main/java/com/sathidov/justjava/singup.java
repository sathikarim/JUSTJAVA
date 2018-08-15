package com.sathidov.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class singup extends AppCompatActivity {
    ArrayList<member> nawmember = new ArrayList<member>();

    EditText singuser,singemail,singpassword;
static String txtuser;
    static String txtemail;
    static String txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
    }

    public void singup(View view) {
        singuser=findViewById(R.id.usersing);
        txtuser=singuser.getText().toString();
        singemail=findViewById(R.id.emailsing);
        txtemail=singemail.getText().toString();
        singpassword=findViewById(R.id.passsing);
        txtpassword=singpassword.getText().toString();
        if (txtemail.equals("")||txtpassword.equals("")||txtuser.equals("")){
            Toast.makeText(this, "OOOPS ...you wrong", Toast.LENGTH_SHORT).show();

        }else{
            Intent ilogin=new Intent (singup.this,login.class);
            ilogin.putExtra("a",txtemail );
            ilogin.putExtra("b",txtuser );
            ilogin.putExtra("c",txtpassword );
          startActivity(ilogin);
            Toast.makeText(this, "you became a member", Toast.LENGTH_SHORT).show();
        }


    }

    public static String geta() {
        if ((!txtemail.equals(""))||(!txtpassword.equals(""))||(!txtuser.equals(""))){
     return txtemail;}else{return "";}
    }

    public static String getb() {
        if ((!txtemail.equals(""))||(!txtpassword.equals(""))||(!txtuser.equals(""))){
            return txtuser;}else{return "";}

    }
    public static String getc() {
        if ((!txtemail.equals(""))||(!txtpassword.equals(""))||(!txtuser.equals(""))){
            return txtpassword;}else{return "";}
    }
}
