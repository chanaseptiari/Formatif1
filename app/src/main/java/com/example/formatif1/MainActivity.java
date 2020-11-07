package com.example.formatif1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.file.FileAlreadyExistsException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnDaftar, btnLogin;
    EditText inputUsername,inputPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDaftar = findViewById(R.id.btnRegis);
        btnLogin = findViewById(R.id.btnLogin);
        inputUsername = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPass);

        btnDaftar.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String Data_FName = getIntent().getStringExtra("Full_Name");
        String Data_Email = getIntent().getStringExtra("ID_Email");
        String Data_Passw = getIntent().getStringExtra("Password");
        String Data_Jk = getIntent().getStringExtra("Jenis_Kelamin");

        String user = inputUsername.getText().toString();
        String pass = inputPassword.getText().toString();
        if (TextUtils.isEmpty(Data_Email)){
            btnLogin.setEnabled(false);
        }
        if(v.getId() == R.id.btnLogin){
            if (user.equals(Data_Email)){
                if(pass.equals(Data_Passw)){
                    Intent dashboard = new Intent(this, Home.class);
                    dashboard.putExtra("Name",Data_FName);
                    dashboard.putExtra("Email",Data_Email);
                    dashboard.putExtra("JK",Data_Jk);
                    startActivity(dashboard);
                } else {
                    inputPassword.setError("Password Berbeda");
                }
            } else  {
                inputUsername.setError("Email Tidak Terdaftar");
            }
        }else if (v.getId() == R.id.btnRegis){
            Intent regis = new Intent(this, Register.class);
            startActivity(regis);
        }

    }
}