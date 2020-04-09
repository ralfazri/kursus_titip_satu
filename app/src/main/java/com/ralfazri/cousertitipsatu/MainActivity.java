package com.ralfazri.cousertitipsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    TextView tvFotgot, tvFb, tvSignUp, tvLanguage, tvLogin, tvUsername, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        tvFotgot = (TextView)findViewById(R.id.tvForgot);
        tvFb = (TextView)findViewById(R.id.tvFb);
        tvSignUp = (TextView)findViewById(R.id.tvSignUp);
        tvLanguage = (TextView)findViewById(R.id.tvLanguage);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvPassword = (TextView)findViewById(R.id.tvPassword);

        tvLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(intent);
            }
        });

        tvFotgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Password Anda ''1234''", Toast.LENGTH_SHORT).show();
            }
        });

        tvFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.facebook.katana");

                if (launchIntent != null) {
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(launchIntent);
                }else{
                    launchIntent= new Intent(Intent.ACTION_VIEW);
                    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    launchIntent.setData(Uri.parse("market://details?id=" + "com.facebook.katana"));
                    startActivity(launchIntent);
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvUsername.getText().toString().equalsIgnoreCase("")||
                tvPassword.getText().toString().equalsIgnoreCase("")){
                    Toast.makeText(MainActivity.this, getString(R.string.username) + " " +
                            getString(R.string.or) + " " + getString(R.string.password) +
                            " " + getString(R.string.empty), Toast.LENGTH_SHORT).show();
                }else if (tvUsername.getText().toString().equals("saya")&&
                            tvPassword.getText().toString().equals("1234")){
                    startActivity(new Intent(MainActivity.this, DashboardActivity.class));
                    tvUsername.setText("");
                    tvPassword.setText("");
                }else {
                    Toast.makeText(MainActivity.this, getString(R.string.username) + " "
                            + getString(R.string.or) + " " + getString(R.string.password) + " " +
                            getString(R.string.falsed), Toast.LENGTH_SHORT).show();
                }
            }
        });




    }


}
