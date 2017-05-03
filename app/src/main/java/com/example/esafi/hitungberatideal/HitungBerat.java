package com.example.esafi.hitungberatideal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.esafi.hitungberatideal.Helper.RealmHelper;

import org.w3c.dom.Text;

public class HitungBerat extends AppCompatActivity {

    private RealmHelper realmHelper;
    private Button save;
    private double gberatIdeal;
    private double ghasilBMI;
    private String gKesimpulan;
    private String gJenisKelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hitung_berat);

        realmHelper = new RealmHelper(HitungBerat.this);

        save = (Button) findViewById(R.id.buSave);

        TextView tvNama = (TextView)findViewById(R.id.tvNama);
        TextView tvBerat = (TextView)findViewById(R.id.tvBerat);
        TextView tvTinggi = (TextView)findViewById(R.id.tvTinggi);
        TextView tvIdeal = (TextView)findViewById(R.id.tvIdeal);
        TextView tvJk = (TextView)findViewById(R.id.tJenisKelamin);

        final String nama = getIntent().getExtras().getString("nama");
        final String berat1 = getIntent().getExtras().getString("berat");
        final String tinggi1 = getIntent().getExtras().getString("tinggi");

        String jk = getIntent().getExtras().getString("jk");
        Integer jk2 = Integer.parseInt(jk);
        final String jenisKelamin;

        final Double berat = Double.parseDouble(berat1);
        final Double tinggi = Double.parseDouble(tinggi1);

        tvNama.setText("Nama : " + nama.toString());
        tvBerat.setText("Berat : " + berat1.toString());
        tvTinggi.setText("Tinggi : " +tinggi1.toString());

        if (jk2 == 1){
            tvIdeal.setText(hitungLk(berat,tinggi));
            jenisKelamin = "Laki - laki";
            gJenisKelamin = jenisKelamin;
            tvJk.setText("Jenis kelamin : " + jenisKelamin);
        }else
        if (jk2 == 2){
            tvIdeal.setText(hitungPr(berat,tinggi));
            jenisKelamin = "Perempuan";
            gJenisKelamin = jenisKelamin;
            tvJk.setText("Jenis kelamin : " + jenisKelamin);
        }

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                realmHelper = new RealmHelper(HitungBerat.this);
                 TextView jenis = (TextView) findViewById(R.id.tvJenisKelamin);

               int tTinggi = Integer.parseInt(tinggi1);
                int tBerat = Integer.parseInt(berat1);

                realmHelper.addDataBerat(nama, gJenisKelamin, tTinggi, tBerat, gberatIdeal, ghasilBMI, gKesimpulan);

                finish();
                //kembali ke MainActivity
                Intent i = new Intent(HitungBerat.this, Main2Activity.class);
                startActivity(i);
            }
        });

    }

    public String hitungLk(double berat, double tinggi){
        Double hasilIdeal = (tinggi-100) - ((tinggi - 100) * 10 / 100 );
        Double hasilBmi = berat / ((tinggi / 100) * (tinggi / 100));
        String kesimpulan ;


        if (hasilBmi < 18)
        {
            kesimpulan = "Kurus";
        }
        else
        if (hasilBmi >= 18 && hasilBmi <= 25)
        {
            kesimpulan = "Normal";
        }
        else
        if (hasilBmi>= 25 && hasilBmi <= 27)
        {
            kesimpulan = "Kegemukan";
        }
        else
        {
            kesimpulan = "Obesitas";
        }

        gberatIdeal =  hasilIdeal;
        ghasilBMI = Math.ceil(hasilBmi);
        gKesimpulan = kesimpulan;

        return ("Berat ideal : "+ hasilIdeal + "\n"+
                "Nilai BMI : "+ Math.ceil(hasilBmi)  +  "\n"+
                "Kesimpulan : "+ kesimpulan+"\n");
    }

    private String hitungPr(double berat, double tinggi){
        Double hasilIdeal = (tinggi - 100) - ((tinggi - 100) * 15 / 100);
        Double hasilBmi = berat / ((tinggi / 100) * (tinggi / 100));
        String kesimpulan ;


        if (hasilBmi < 17)
        {
            kesimpulan = "Kurus";
        }
        else
        if (hasilBmi >= 17 && hasilBmi <= 23)
        {
            kesimpulan = "Normal";
        }
        else
        if (hasilBmi>= 24 && hasilBmi <= 27)
        {
            kesimpulan = "Kegemukan";
        }
        else
        {
            kesimpulan = "Obesitas";
        }

        return ("Berat ideal : "+ hasilIdeal + "\n"+
                "Nilai BMI : "+ Math.ceil(hasilBmi)  +  "\n"+
                "Kesimpulan : "+ kesimpulan+"\n");
    }

    public void buCancel(View view) {
        Intent back = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(back);
    }


}
