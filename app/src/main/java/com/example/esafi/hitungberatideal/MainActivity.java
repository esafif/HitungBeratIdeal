package com.example.esafi.hitungberatideal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buLaki(View view) {
        EditText nama1 = (EditText) findViewById(R.id.edNama);
        EditText berat1 = (EditText) findViewById(R.id.edBerat);
        EditText tinggi1 = (EditText) findViewById(R.id.edTinggi);

        String nama = nama1.getText().toString();
        String berat = berat1.getText().toString();
        String tinggi = tinggi1.getText().toString();
        String jk = "1" ;


        Intent sendData = new Intent(view.getContext(), HitungBerat.class);
        sendData.putExtra("jk", jk.toString());
        sendData.putExtra("nama", nama);
        sendData.putExtra("berat", berat);
        sendData.putExtra("tinggi", tinggi);
        startActivity(sendData);
        finish();
    }

    public void buPerempuan(View view) {
        EditText nama1 = (EditText) findViewById(R.id.edNama);
        EditText berat1 = (EditText) findViewById(R.id.edBerat);
        EditText tinggi1 = (EditText) findViewById(R.id.edTinggi);

        String nama = nama1.getText().toString();
        String berat = berat1.getText().toString();
        String tinggi = tinggi1.getText().toString();
        String jk = "2" ;

        Intent sendData = new Intent(view.getContext(), HitungBerat.class);
        sendData.putExtra("jk",jk);
        sendData.putExtra("nama", nama);
        sendData.putExtra("berat", berat);
        sendData.putExtra("tinggi", tinggi);
        startActivity(sendData);
        finish();
    }
}
