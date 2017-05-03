package com.example.esafi.hitungberatideal;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.esafi.hitungberatideal.Adapter.AdapterData;
import com.example.esafi.hitungberatideal.Helper.DataBerat;
import com.example.esafi.hitungberatideal.Helper.RealmHelper;
import com.example.esafi.hitungberatideal.Model.DataBeratModel;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";


    private RecyclerView recyclerView;
    private RealmHelper helper;
    private ArrayList<DataBeratModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        data = new ArrayList<>();
        helper = new RealmHelper(Main2Activity.this);

        recyclerView = (RecyclerView) findViewById(R.id.rvArticle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        setRecyclerView();
    }

    public void setRecyclerView() {
        try {
            data = helper.findAllArticle();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AdapterData adapter = new AdapterData(data, new AdapterData.OnItemClickListener() {

            @Override
            public void onClick(DataBeratModel item) {
                Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                i.putExtra("id", item.getId());
                i.putExtra("nama", item.getNama());
                i.putExtra("jeniskelamin", item.getJenisKelamin());
                startActivity(i);
                finish();
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            data = helper.findAllArticle();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setRecyclerView();
    }
}
