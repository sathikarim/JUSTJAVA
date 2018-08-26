package com.sathidov.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class singup extends AppCompatActivity {
    ArrayList<member> nawmember ;

    EditText singuser,singemail,singpassword;
static String txtuser;
    static String txtemail;
    static String txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        Intent i = this.getIntent();
       nawmember = i.getParcelableArrayListExtra("array2");
    }

    public void singup(View view) {

        singuser=findViewById(R.id.usersing);
        txtuser=singuser.getText().toString();
        singemail=findViewById(R.id.emailsing);
        txtemail=singemail.getText().toString();   singpassword=findViewById(R.id.passsing);

        txtpassword=singpassword.getText().toString();
        if (txtemail.equals("")||txtpassword.equals("")||txtuser.equals("")){
            Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show();

        }else{
            nawmember.add(new member(txtemail,txtuser,txtpassword));
            Intent ilogin=new Intent (singup.this,login.class);
            ilogin.putParcelableArrayListExtra("array3",nawmember);
           ilogin.putExtra("test","123");
            startActivity(ilogin);
            Toast.makeText(this, R.string.newmember, Toast.LENGTH_SHORT).show();
            finish();
        }


    }


}
