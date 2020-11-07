package com.example.formatif1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity implements View.OnClickListener{
Button btnLogout;
TextView FullName,EmailID,JenisKelamin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(this);

        FullName = findViewById(R.id.FullName);
        EmailID = findViewById(R.id.EmailID);
        JenisKelamin = findViewById(R.id.JenisKelamin);

        String data1 = getIntent().getStringExtra("Full_Name");
        String data2 = getIntent().getStringExtra("ID_Email");
        String data3 = getIntent().getStringExtra("Jenis_Kelamin");

        FullName.setText(data1);
        EmailID.setText(data2);
        JenisKelamin.setText(data3);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnLogout){
            AlertDialog.Builder Notif = new AlertDialog.Builder(this);
            Notif.setTitle("Logout");
            Notif.setMessage("Ya untuk Logout");
            Notif.setCancelable(true);
            Notif.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            Notif.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent logout = new Intent();
                    logout.putExtra("Logout", "Anda Telah Logout");
                    setResult(Activity.RESULT_OK, logout);
                    finish();
                }
            });
            Notif.show();
        }
    }
}