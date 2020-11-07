package com.example.formatif1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDaftar, btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDaftar = findViewById(R.id.btnRegis);
        btnLogin = findViewById(R.id.btnLogin);

        btnDaftar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){
            Intent dashboard = new Intent(this, Home.class);
            startActivity(dashboard);
        }else if (v.getId() == R.id.btnRegis){
            Intent regis = new Intent(this, Register.class);
            startActivity(regis);
        }

    }
}