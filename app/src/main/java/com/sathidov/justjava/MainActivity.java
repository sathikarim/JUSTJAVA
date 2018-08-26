package com.sathidov.justjava;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView txtNumberTea, txtNumberCoffee, txtNumberCapp, txtTotal;
    CheckBox cbWhippedCreamCoffee, cbWhippedCreamCapp, cbMilk, cbVanilla, cbCocolate, cbLimon;
    int quantityTea = 0;
    int priceTea;
    int quantityCoffee = 0;
    int priceCoffee;
    int quantityCapp = 0;
    int priceCapp;
    int total = 0;
    String message = "";
    private Locale myLocale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=this.getIntent();
       txtTotal = findViewById(R.id.txttotal);
        txtTotal.setText(NumberFormat.getCurrencyInstance().format(0));
       txtNumberCapp = findViewById(R.id.numbercapp);
                           txtNumberCoffee = findViewById(R.id.numbercoffee);

        txtNumberTea = findViewById(R.id.numbertea);
        cbCocolate = findViewById(R.id.CB_chocolate);
        cbLimon = findViewById(R.id.CB_limon);
        cbWhippedCreamCoffee = findViewById(R.id.CB_WhippedCream_coffee);
        cbWhippedCreamCapp = findViewById(R.id.CB_WhippedCream_capp);
        cbMilk = findViewById(R.id.CB_milk);
        cbVanilla = findViewById(R.id.CB_vanilla);
         name = findViewById(R.id.name);
        Intent data=getIntent();
name.setText(getString(R.string.hi)+data.getStringExtra("nameacc"));
        cbCocolate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
        cbLimon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
        cbWhippedCreamCoffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
        cbWhippedCreamCapp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
        cbMilk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
        cbVanilla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                chingetextprice();

            }
        });
    }

    public void pluscoffee(View view) {

        if (quantityCoffee < 100) {
            quantityCoffee += 1;

            txtNumberCoffee.setText("" + quantityCoffee);
            chingetextprice();
        } else {
            Toast.makeText(this, R.string.maxcupjava, Toast.LENGTH_SHORT).show();
        }
    }

    public void minescoffee(View view) {
        if (quantityCoffee > 0) {
            quantityCoffee -= 1;
            txtNumberCoffee.setText("" + quantityCoffee);
            chingetextprice();

        } else {
            Toast.makeText(this, R.string.mincupjava, Toast.LENGTH_SHORT).show();
        }
    }
    public void plustea(View view) {
        if (quantityTea < 100) {
            quantityTea += 1;
            txtNumberTea.setText("" + quantityTea);
            chingetextprice();

        } else {
            Toast.makeText(this, R.string.maxcupjava, Toast.LENGTH_SHORT).show();
        }
    }

    public void minestea(View view) {
        if (quantityTea > 0) {
            quantityTea -= 1;
            txtNumberTea.setText("" + quantityTea);
            chingetextprice();

        } else {
            Toast.makeText(this,  R.string.mincupjava, Toast.LENGTH_SHORT).show();
        }
    }

    public void pluscapp(View view) {
        if (quantityCapp < 100) {
            quantityCapp += 1;
            txtNumberCapp.setText("" + quantityCapp);
            chingetextprice();

        } else {
            Toast.makeText(this, R.string.maxcupjava, Toast.LENGTH_SHORT).show();
        }
    }

    public void minescapp(View view) {
        if (quantityCapp > 0) {
            quantityCapp -= 1;
            txtNumberCapp.setText("" + quantityCapp);
            chingetextprice();

        } else {
            Toast.makeText(this,  R.string.mincupjava, Toast.LENGTH_SHORT).show();
        }
    }

    private int calTotal() {
        priceCapp = 15;
        priceCoffee = 5;
        priceTea = 7;
        if (cbMilk.isChecked()) {
            priceTea += 1;
        }
        if (cbLimon.isChecked()) {
            priceTea += 1;
        }
        if (cbVanilla.isChecked()) {
            priceCapp += 2;
        }
        if (cbWhippedCreamCapp.isChecked()) {
            priceCapp += 1;
        }
        if (cbWhippedCreamCoffee.isChecked()) {
            priceCoffee += 1;
        }
        if (cbCocolate.isChecked()) {
            priceCoffee += 2;
        }

        return total = priceCapp * quantityCapp + quantityTea * priceTea + quantityCoffee * priceCoffee;
    }

    private void chingetextprice() {
        txtTotal.setText(NumberFormat.getCurrencyInstance().format(calTotal()));
    }

    public void oreder(View view) {
        if (total == 0) {
            Toast.makeText(this, R.string.zerototal, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_TEXT, txtmessage());
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"khhb17@hotmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.namejava) +"  "+ name.getText().toString());

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
    }

    private String txtmessage() {
        message="";
        message+=getString(R.string.summary)+"\n";
        message+="--------------"+"\n";

        if (quantityCoffee != 0) {
            message += "\n";
            message = message + getString(R.string.coffejava) + quantityCoffee + getString(R.string.cupjava) + "\n";

            if (cbWhippedCreamCoffee.isChecked()) {
                message += getString(R.string.wctjava)+"\n";
            } else {
                message += getString(R.string.wcfjava)+"\n";

            }
            if (cbCocolate.isChecked()) {
                message += getString(R.string.choco_tjava)+"\n";
            } else {
                message += getString(R.string.choco_fjava)+"\n";

            }
        }
        if (quantityTea != 0) {
            message += "\n";
            message = message + getString(R.string.teajava) + quantityTea + getString(R.string.cupjava)+ "\n";

            if (cbMilk.isChecked()) {
                message += getString(R.string.milk_tjava)+"\n";
            } else {
                message += getString(R.string.milk_fjava)+"\n";

            }
            if (cbLimon.isChecked()) {
                message += getString(R.string.limon_tjava)+"\n";
            } else {
                message += getString(R.string.limon_fjava)+"\n";

            }
        }
        if (quantityCapp != 0) {
            message += "\n";
            message = message + getString(R.string.cappjava) + quantityCapp + getString(R.string.cupjava) + "\n";

            if (cbWhippedCreamCapp.isChecked()) {
                message += getString(R.string.wctjava)+"\n";
            } else {
                message +=getString(R.string.wcfjava)+"\n";

            }
            if (cbVanilla.isChecked()) {
                message += getString(R.string.vanilla_tjava)+"\n";
            } else {
                message += getString(R.string.vanilla_fjava)+"\n";

            }
        }
        message += "\n"+"--------------------"+"\n";
        message=message + getString(R.string.totaljava) + total +"\n"+ getString(R.string.thnxjava);


        return message;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {


            case R.id.chnglang:

                final Dialog dialog1 = new Dialog(MainActivity.this);
                dialog1.setContentView(R.layout.diloglang);
              Button okthm = (Button) dialog1.findViewById(R.id.oklang);
                Button nothm = (Button) dialog1.findViewById(R.id.backlang);
                nothm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog1.dismiss();
                    }
                });
                okthm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String lang = "en";
                        RadioGroup radiolangGroup = (RadioGroup) dialog1.findViewById(R.id.radiolang);
                        int selectedId = radiolangGroup.getCheckedRadioButtonId();
                        switch (selectedId) {
                           case R.id.lang_ar:
                               lang = "ar";
                                break;
                            case R.id.lang_en:
                                lang = "en";
                                break;
                        }

                        changeLang(lang);

                        dialog1.dismiss();}

                });
                dialog1.show();

                return true;
            case R.id.logout:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage(R.string.logoutjava);
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent i=new Intent(MainActivity.this,login.class);
                                startActivity(i);
                                finish();
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        R.string.no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void saveLocale(String lang)
    {
        String langPref = "Language";
        SharedPreferences prefs = getSharedPreferences("CommonPrefs", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(langPref, lang);
        editor.commit();
    }


    public void changeLang(String lang)
    {
        if (lang.equalsIgnoreCase(""))
            return;
        if(lang.equals("ar")){        myLocale = new Locale(lang,"DZ");
        }else{
            myLocale = new Locale(lang);

        }
        saveLocale(lang);
        Locale.setDefault(myLocale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = myLocale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
