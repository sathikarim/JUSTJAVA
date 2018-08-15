package com.sathidov.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    ArrayList<member> whomember = new ArrayList<member>();
    EditText userlog, passlog;
    String accont, passsword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //add member sathi karim
        whomember.add(new member("justjava@mail.com", "Sathi Karim", "2018"));
        //get info member from page singup
        Intent data=getIntent();
        String a=data.getStringExtra("a");
        String b=data.getStringExtra("b");
        String c=data.getStringExtra("c");
        //add member  from page singup
        whomember.add(new member(a,b,c));
        TextView forgttxt=findViewById(R.id.forgt);
        //intent form login app to forgot app
        forgttxt.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent inta = new Intent(login.this, forg.class);
                                            startActivity(inta);
                                        }
                                    }

        );

    }
// when click login
    public void login(View view) {
        // t valure tast member
        int t=0;
        //get info member from page login
        userlog = findViewById(R.id.acclogin);
        accont = userlog.getText().toString();
        passlog = findViewById(R.id.passlogin);
        passsword = passlog.getText().toString();
        //search and Check
        for (int j = 0; j < whomember.size(); j++) {
            String memuser=whomember.get(j).getUesrname();
            String mempas=whomember.get(j).getPasword();
            String memeami=whomember.get(j).getemail();
            // if found member go to page justjava
            if ((accont.equals(memuser)||accont.equals(memeami))&&passsword.equals(mempas)) {
                Intent i = new Intent(login.this, MainActivity.class);
                i.putExtra("nameacc",memuser);
                startActivity(i);
                t=1;
            }
        }
                 // if not found member go to page justjava
        if(t==0){
            Toast.makeText(this, "OOOPS ...you wrong", Toast.LENGTH_SHORT).show();
        }

    }
//when click singup
    public void sii(View view) {
        Intent i = new Intent(login.this, singup.class);
        startActivity(i);
    }
}
