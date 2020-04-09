package com.ralfazri.cousertitipsatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    TextView tvSignUp, tvUsername, tvPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().hide();

        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvPassword = (TextView)findViewById(R.id.tvPassword);
        tvSignUp = (TextView)findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvUsername.getText().toString().isEmpty()||tvPassword.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, getString(R.string.emptyy), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignUpActivity.this, getString(R.string.done), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                }
            }
        });
    }
}
