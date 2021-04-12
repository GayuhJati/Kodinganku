package com.example.tugas_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btVertic, btHorizon, btGrid;
    private int tanda = 0;
    private RecyclerView rvPoster;
    private ArrayList<PosterModel> listPoster = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btVertic = findViewById(R.id.vertic);
        btHorizon = findViewById(R.id.horizon);
        btGrid = findViewById(R.id.grid);



        rvPoster = findViewById(R.id.item_list);
        rvPoster.setHasFixedSize(true);
        listPoster.addAll(PosterData.getListData());

        showRecycleList();

        btVertic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTanda(0);
                showRecycleList();
            }
        });
        
        btHorizon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTanda(1);
                showRecycleList();
            }
        });

        btGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTanda(2);
                showRecycleList();
            }
        });

    }

    private void showRecycleList() {
        if (getTanda()==0) rvPoster.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        else if (getTanda()==1) rvPoster.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        else if (getTanda()==2) rvPoster.setLayoutManager(new GridLayoutManager(this,2));
        else  rvPoster.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        PosterAdapter posAdapter = new PosterAdapter(this);
        posAdapter.setPosterModels(listPoster);
        posAdapter.setOrientasi(getTanda());
        rvPoster.setAdapter(posAdapter);

        posAdapter.setOnItemClickListener(new PosterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, DetailFilm.class);
                intent.putExtra("posisi", position);
                startActivity(intent);
            }
        });
    }

    public int getTanda() {
        return tanda;
    }

    public void setTanda(int tanda) {
        this.tanda = tanda;
    }
}