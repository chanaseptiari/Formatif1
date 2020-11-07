package com.example.formatif1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Register extends AppCompatActivity implements View.OnClickListener {
Button btnDaftar;
EditText FName,LName,Email,Pass,KPass;
RadioGroup jenisKelamin;
RadioButton jkdipilih;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnDaftar = findViewById(R.id.btnDaftar);
        btnDaftar.setOnClickListener(this);

        FName = findViewById(R.id.dft_F_name);
        LName = findViewById(R.id.dft_F_name);
        Email = findViewById(R.id.dft_F_name);
        Pass = findViewById(R.id.dft_F_name);
        KPass = findViewById(R.id.dft_F_name);
        jenisKelamin = findViewById(R.id.jenisKelamin);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnDaftar){
            Intent login = new Intent(this, Home.class);
            int dipilih = jenisKelamin.getCheckedRadioButtonId();
            if (dipilih != -1){
                jkdipilih = findViewById(dipilih);
                String jk = jkdipilih.getText().toString();
                login.putExtra("Jenis Kelamin",jk);
            }
            String FullName = FName.getText().toString() + " " + LName.getText().toString();
            String EmailID = Email.getText().toString();
            login.putExtra("Full Name",FullName);
            login.putExtra("ID Email",EmailID);
            startActivity(login);
        }

    }
}